<template>
    <div>

<div style="height: 50px; font-size: 30px; color: #606266">新增角色</div>
<br>
<br>

        <el-form :model="form" label-width="85px" label-position="left">
            <el-row>
                <el-col :span="12">
                    <el-form-item label="角色名：" style="margin-right: 20px;">
                        <el-input maxlength="255" show-word-limit v-model="form.roleName" placeholder="请输入"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>  
             <el-row>
                <el-col :span="12">
                    <el-form-item label="角色描述：" style="margin-right: 20px;">
                        <el-input maxlength="255" show-word-limit type="textarea" :rows="2" v-model="form.roleRemark" placeholder="请输入"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            
            <el-row>
                <el-col :span="12">
                    <el-button type="primary" @click="saveRole">保存</el-button>
                    <el-button type="primary" @click="gotoRolePage">返回</el-button>
                </el-col>
            </el-row>


        </el-form>

    </div>



    
</template>

<script>
    //import NavMenu from  "../components/NavMenu";
export default {
        name: 'AddRole',
        components: {

        },
  
    data(){
      return {
        form: {
            roleName: '',
            roleRemark: ''
        },
          tableData: []
      }
    },

    mounted(){

    },
    methods: {

        saveRole(){
            alert("saveRole......");
            console.log(JSON.stringify(this.form));
            if(this.form.roleName!=''&&this.form.roleRemark!='')
            {
                this.$http.post(baseURL + "/member/role/save",this.form).then((res) => {
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

        gotoRolePage(){
            this.$router.push('Role');
        }

    }

    }



</script>

<style scoped>

</style>
