<template>
    <div>

<div style="height: 50px; font-size: 30px; color: #606266">修改角色信息</div>
<br>
<br>

        <el-form :model="editForm" label-width="85px" label-position="left">
            <el-row>
                <el-col :span="12">
                    <el-form-item label="角色名：" style="margin-right: 20px;">
                        <el-input maxlength="255" show-word-limit v-model="editForm.roleName" placeholder="请输入"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="12">
                    <el-form-item label="角色描述：" style="margin-right: 20px;">
                        <el-input maxlength="255" show-word-limit type="textarea" :rows="2" v-model="editForm.roleRemark" placeholder="请输入"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            
            <el-row>
                <el-col :span="12">
                    <el-button type="primary" @click="updateRole">保存</el-button>
                    <el-button type="primary" @click="gotoRolePage">返回</el-button>
                </el-col>
            </el-row>


        </el-form>

    </div>



    
</template>

<script>
export default {
        name: 'EditRole',
        components: {

        },
  
    data(){
      return {
        editForm: {
            roleName: '',//角色名称
            roleRemark: '' //角色描述
        }
      }
    },

    mounted(){ 
        this.getRole();
    },

    methods: {

        updateRole(){
            alert("updateRole......");
            console.log(JSON.stringify(this.form));
            if(this.editForm.roleName!=''&&this.editForm.roleRemark!='')
            {
                this.$http.post(baseURL + "/member/role/update",this.editForm).then((res) => {
                console.log(res);
                    if(res.code === 0){
						 alert('操作成功');
                         this.$router.push('Role');
					}else{
						alert(res.msg);
					}

            }).catch((err) => {
                console.log('err');
            })
            }
            else
                alert('各项信息不允许有空白!');
        }, 
        
        getRole(){
            let roleId = Number(this.$route.query.id);
            alert("跳转到修改角色界面，RoleId = " +roleId);
           
            this.$http.get(baseURL + "/member/role/info/" + roleId).then((res) => {
                    if(res.code === 0){
                        console.log('editForm:');
                        console.log(res.roleInfo);
                        this.editForm=res.roleInfo;
					}else{
						alert(res.msg);
					}

            }).catch((err) => {
                console.log('err');
            })
        },

        gotoRolePage(){
            this.$router.push('Role');
        }
    }
    }



</script>

<style scoped>

</style>
