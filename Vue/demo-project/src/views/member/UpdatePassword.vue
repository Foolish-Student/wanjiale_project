<template>
    <div>

<div style="height: 50px; font-size: 30px; color: #606266">修改子账户密码</div>
<br>
<br>

        <el-form :model="editForm" label-width="85px" label-position="left">
            <el-row>
                <el-col :span="10">
                    <el-form-item label="原密码：" style="margin-right: 20px;">
                        <el-input maxlength="16" v-model="editForm.oldPassword" show-password placeholder="请输入原始密码"></el-input>
                    </el-form-item>
                </el-col>
             </el-row>

            <el-row>
                <el-col :span="10">
                    <el-form-item label="新密码：" style="margin-right: 20px;">
                        <el-input maxlength="16" v-model="editForm.newPassword" show-password placeholder="请输入不超过16位的新密码"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="10">
                    <el-form-item label="确认密码：" style="margin-right: 20px;">
                        <el-input maxlength="16" v-model="editForm.againPassword" show-password placeholder="请再次输入新密码"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="12">
                    <el-button type="primary" @click="updatePassword">保存</el-button>
                    <el-button type="primary" @click="gotoUserPage">返回</el-button>
                </el-col>
            </el-row>


        </el-form>

    </div>



    
</template>

<script>
export default {
        name: 'UpdatePassword',
        components: {

        },
  
    data(){
      return {
        editForm: {
            userId:'',
            oldPassword: '', //旧密码
            newPassword: '',//新密码
            againPassword:''//确认密码
        }
      }
    },


    mounted(){ 

        this.getPassword();
    },

    methods: {

        updatePassword(){
            alert("updatePassword......");
            console.log(JSON.stringify(this.form));
        if(this.editForm.newPassword=='')
        {
            alert('不能输入空密码！');
        }
        else if(this.editForm.newPassword==this.editForm.againPassword){
                this.$http.post(baseURL + "/member/user/update/password",this.editForm).then((res) => {
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
            alert('两次输入的新密码不一致！');
        }, 
        
        getPassword(){
            let userId = Number(this.$route.query.id);
            this.editForm.userId=userId;
            alert("跳转到修改用户密码界面，UserId = " +userId);
        },

        gotoUserPage(){
            this.$router.push('User');
        }
    }
    }
</script>
<style scoped>
</style>