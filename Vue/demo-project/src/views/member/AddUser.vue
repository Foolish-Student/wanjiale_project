<template>
    <div>

<div style="height: 50px; font-size: 30px; color: #606266">新增子账户页</div>
<br>
<br>

        <el-form :model="form" label-width="85px" label-position="left">
            <el-row>
                <el-col :span="12">
                    <el-form-item label="用户名：" style="margin-right: 20px;">
                        <el-input maxlength="255" show-word-limit type="textarea" :rows="2" v-model="form.loginName" placeholder="请输入"></el-input>
                    </el-form-item>
                </el-col>
             </el-row>

            <el-row>
                <el-col :span="12">
                    <el-form-item label="真实姓名：" style="margin-right: 20px;">
                        <el-input maxlength="255" show-word-limit v-model="form.userName" placeholder="请输入"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="6">
                    <el-form-item label="角色：" style="margin-right: 20px;">
                        <el-select v-model="form.roleName" placeholder="请选择">
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
                        <el-select v-model="form.sex" placeholder="请选择">
                            <el-option label="男" value="男"></el-option>
                            <el-option label="女" value="女"></el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
            </el-row>
        
            <el-row>
                <el-col :span="12">
                    <el-form-item label="手机号码：" style="margin-right: 20px;">
                        <el-input maxlength="25" show-word-limit v-model="form.mobile" placeholder="请输入"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="12">
                    <el-form-item label="电子邮箱：" style="margin-right: 20px;">
                        <el-input maxlength="255" show-word-limit v-model="form.email" placeholder="请输入"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="12">
                    <el-form-item label="备注：" style="margin-right: 20px;">
                        <el-input maxlength="255" show-word-limit type="textarea" :rows="2" v-model="form.remark" placeholder="请输入"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            
            <el-row>
                <el-col :span="12">
                    <el-button type="primary" @click="saveUser">保存</el-button>
                    <el-button type="primary" @click="gotoUserPage">返回</el-button>
                </el-col>
            </el-row>


        </el-form>

    </div>



    
</template>

<script>
    //import NavMenu from  "../components/NavMenu";
export default {
        name: 'AddUser',
        components: {

        },
  
    data(){
      return {
        form: {
            loginName: '',
            roleName: '',
            userName: '',
            sex: '',
            mobile: '',
            email: '',
            status: '',
            remark: ''
        },
          tableData: []
      }
    },

    mounted(){

    },
    methods: {

        saveUser(){
            alert("saveUser......");
            console.log(JSON.stringify(this.form));
            if(this.form.loginName!='' && this.form.userName!='' && this.form.roleName!='' && this.form.sex!='' && this.form.mobile!='' && this.form.email!='' && this.form.remark!='')
            {
                this.$http.post(baseURL + "/member/user/save",this.form).then((res) => {
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

        gotoUserPage(){
            this.$router.push('User');
        }

    }

    }



</script>

<style scoped>

</style>
