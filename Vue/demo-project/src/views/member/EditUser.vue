<template>
    <div>

<div style="height: 50px; font-size: 30px; color: #606266">修改子账户信息</div>
<br>
<br>

        <el-form :model="editForm" label-width="85px" label-position="left">
            <el-row>
                <el-col :span="12">
                    <el-form-item label="用户名：" style="margin-right: 20px;">
                        <el-input maxlength="255" show-word-limit type="textarea" :rows="2" v-model="editForm.loginName" placeholder="请输入"></el-input>
                    </el-form-item>
                </el-col>
             </el-row>

            <el-row>
                <el-col :span="12">
                    <el-form-item label="真实姓名：" style="margin-right: 20px;">
                        <el-input maxlength="255" show-word-limit v-model="editForm.userName" placeholder="请输入"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="6">
                    <el-form-item label="角色：" style="margin-right: 20px;">
                        <el-select v-model="editForm.roleName" placeholder="请选择">
                            <el-option label="总经办" value="总经办"></el-option>
                            <el-option label="生产办" value="生产办"></el-option>
                            <el-option label="IT部" value="IT部"></el-option>
                            <el-option label="电商部" value="电商部"></el-option>
                            <el-option label="采购部" value="采购部"></el-option>
                            <el-option label="财务部" value="财务部"></el-option>
                        </el-select>
                    </el-form-item>

                </el-col>
            </el-row>

            <el-row>
                <el-col :span="6">
                    <el-form-item label="性别：" style="margin-right: 20px;">
                        <el-select v-model="editForm.sex" placeholder="全部">
                            <el-option label="男" value="男"></el-option>
                            <el-option label="女" value="女"></el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
            </el-row>
        
            <el-row>
                <el-col :span="12">
                    <el-form-item label="手机号码：" style="margin-right: 20px;">
                        <el-input maxlength="25" show-word-limit v-model="editForm.mobile" placeholder="请输入"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="12">
                    <el-form-item label="电子邮箱：" style="margin-right: 20px;">
                        <el-input maxlength="255" show-word-limit v-model="editForm.email" placeholder="请输入"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="12">
                    <el-form-item label="备注：" style="margin-right: 20px;">
                        <el-input maxlength="255" show-word-limit type="textarea" :rows="2" v-model="editForm.remark" placeholder="请输入"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            
            <el-row>
                <el-col :span="12">
                    <el-button type="primary" @click="updateUser">保存</el-button>
                    <el-button type="primary" @click="gotoUserPage">返回</el-button>
                </el-col>
            </el-row>


        </el-form>

    </div>



    
</template>

<script>
export default {
        name: 'EditUser',
        components: {

        },
  
    data(){
      return {
        editForm: {
            loginName: '', //项目名称
            userName: '', //项目描述
            roleName: '', //项目名称
            sex: '', //性别
            email: '',   //邮箱
            remark: '' //描述
        }
      }
    },


    mounted(){ 

        this.getUser();
    },

    methods: {

        updateUser(){
            alert("updateUser......");
            console.log(JSON.stringify(this.form));
            if(this.editForm.loginName!='' && this.editForm.userName!='' && this.editForm.roleName!='' && this.editForm.sex!='' && this.editForm.mobile!='' && this.editForm.email!='' && this.editForm.remark!='')
           { 
               this.$http.post(baseURL + "/member/user/update",this.editForm).then((res) => {
                console.log(res);
                    if(res.code === 0){
						 alert('操作成功');
                         this.$router.push('User');
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
        
        getUser(){
            let userId = Number(this.$route.query.id);
            alert("跳转到修改用户界面，UserId = " +userId);
           
            this.$http.get(baseURL + "/member/user/info/" + userId).then((res) => {
                    if(res.code === 0){
                        console.log('editForm:');
                        console.log(res.userInfo);
                        this.editForm =res.userInfo;
					}else{
						alert(res.msg);
					}

            }).catch((err) => {
                console.log('err');
            })
        },

        gotoUserPage(){
            this.$router.push('User');
        }

    }

    }



</script>

<style scoped>

</style>
