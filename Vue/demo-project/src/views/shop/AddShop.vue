<template>
  <div>

    <div style="height: 50px; font-size: 30px; color: #606266">新增网店</div>
    <br>
    <br>

    <el-form :model="form" label-width="85px" label-position="left">
<!--      <el-row>-->
<!--        <el-col :span="12">-->
<!--          <el-form-item label="序号" style="margin-right: 20px;">-->
<!--            <el-input v-model="form.shopId" placeholder="请输入" maxlength="11" show-word-limit></el-input>-->
<!--          </el-form-item>-->
<!--        </el-col>-->
<!--      </el-row>-->

      <el-row>
        <el-col :span="12">
          <el-form-item label="平台类别" style="margin-right: 20px;">
            <el-input v-model="form.shopCategory" placeholder="请输入" maxlength="50" show-word-limit></el-input>
          </el-form-item>
        </el-col>
      </el-row>


      <el-row>
        <el-col :span="12">
          <el-form-item label="网址" style="margin-right: 20px;">
            <el-input v-model="form.shopUrl" placeholder="请输入" maxlength="255" show-word-limit></el-input>
          </el-form-item>
        </el-col>
      </el-row>

      <el-row>
        <el-col :span="12">
          <el-form-item label="账号" style="margin-right: 20px;">
            <el-input v-model="form.account" placeholder="请输入" maxlength="20" show-word-limit></el-input>
          </el-form-item>
        </el-col>
      </el-row>

      <el-row>
        <el-col :span="12">
          <el-form-item label="密码" style="margin-right: 20px;">
            <el-input v-model="form.password" placeholder="请输入" maxlength="20" show-word-limit></el-input>
          </el-form-item>
        </el-col>
      </el-row>


      <el-row>
        <el-col :span="5">
          <el-form-item label="状态" style="margin-right: 20px;">
            <el-select v-model="form.status" placeholder="全部">
              <el-option label="启用" value="1"></el-option>
              <el-option label="禁用" value="0"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>


<!--      <el-row>-->
<!--        <el-col :span="12">-->
<!--          <el-form-item label="修改时间" style="margin-right: 20px;">-->
<!--            <el-input v-model="form.updateTime" placeholder="请输入"></el-input>-->
<!--          </el-form-item>-->
<!--        </el-col>-->
<!--      </el-row>-->
      <el-row>
        <el-col :span="12">
          <el-form-item label="修改人" style="margin-right: 20px;">
            <el-input v-model="form.updateBy" placeholder="请输入" maxlength="50" show-word-limit></el-input>
          </el-form-item>
        </el-col>
      </el-row>

      <el-row>
        <el-col :span="12">
          <el-button @click="saveUser">保存</el-button>
          <el-button @click="gotoUserPage">返回</el-button>
        </el-col>
      </el-row>


    </el-form>

  </div>


</template>

<script>
//import NavMenu from  "../components/NavMenu";
export default {
  name: 'Add',
  components: {},

  data() {
    return {
      form: {
        shopId: '',
        shopCategory: '',
        shopUrl: '',
        account: '',
        password: '',
        status: '',
        updateTime: '',
        updateBy: ''
      },
      tableData: []
    }
  },

  mounted() {

  },
  methods: {

    saveUser() {
      if (this.form.shopCategory == null || this.form.shopCategory == "" || this.form.shopUrl == null || this.form.shopUrl == ""|| this.form.account == null ||
          this.form.accountk == "" ||this.form.password == null || this.form.password == null|| this.form.status == null || this.form.status == ""||
          this.form.updateBy == null || this.form.updateBy == ""){
        alert("有信息为空！！！！");
        return;
      }

      console.log(JSON.stringify(this.form));
      this.$http.post(baseURL + "/store/add", this.form).then((res) => {
        console.log(res);
        if (res.code === 0) {
          this.$alert('插入成功', '系统提示', {
            confirmButtonText: '确定',
            callback: action => {
              this.$message({
                type: 'success',
                message: `系统提示: 插入成功`
              });
            }
          });
          this.$router.push('Shop');
        } else {
          alert(res.msg);
        }

      }).catch((err) => {
        console.log('err');
      })
    },

    gotoUserPage() {
      this.$router.push('Shop');
    }

  }
}
</script>

<style scoped>

</style>
