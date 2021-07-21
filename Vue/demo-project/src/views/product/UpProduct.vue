<template>
  <div>


    <div style="height: 50px; font-size: 30px; color: #606266">修改产品信息</div>
    <br>
    <br>

    <el-form :model="form" label-width="100px" label-position="left">
      <el-row>
        <el-col :span="12">
          <el-form-item label="序号" style="margin-right: 20px;">
            <el-input v-model="form.id" placeholder="请输入" maxlength="50" show-word-limit></el-input>
          </el-form-item>
        </el-col>
      </el-row>

      <el-row>
        <el-col :span="12">
          <el-form-item label="产品编码" style="margin-right: 20px;">
            <el-input v-model="form.productNum" placeholder="请输入" maxlength="50" show-word-limit></el-input>
          </el-form-item>
        </el-col>
      </el-row>


      <el-row>
        <el-col :span="12">
          <el-form-item label="产品型号" style="margin-right: 20px;">
            <el-input v-model="form.productModel" placeholder="请输入" maxlength="50" show-word-limit></el-input>
          </el-form-item>
        </el-col>
      </el-row>

      <el-row>
        <el-col :span="12">
          <el-form-item label="产品名称" style="margin-right: 20px;">
            <el-input v-model="form.productName" placeholder="请输入" maxlength="50" show-word-limit></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="5">
          <el-form-item label="类目" style="margin-right: 20px;">
            <el-select v-model="form.productCategory" placeholder="全部">
              <el-option label="热水电商" value="热水电商"></el-option>
              <el-option label="厨房电商" value="厨房电商"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <el-form-item label="条形码" style="margin-right: 20px;">
            <el-input v-model="form.barCode" placeholder="请输入" maxlength="50" show-word-limit></el-input>
          </el-form-item>
        </el-col>
      </el-row>

      <el-row>
        <el-col :span="12">
          <el-form-item label="单位" style="margin-right: 20px;">
            <el-input v-model="form.productUnit" placeholder="请输入" maxlength="50" show-word-limit></el-input>
          </el-form-item>
        </el-col>
      </el-row>

      <el-row>
        <el-col :span="12">
          <el-form-item label="规格" style="margin-right: 20px;">
            <el-input v-model="form.productSize" placeholder="请输入" maxlength="50" show-word-limit></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <el-form-item label="零售价（元）" style="margin-right: 20px;">
            <el-input v-model="form.productPrice" placeholder="请输入" maxlength="11" show-word-limit></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <el-form-item label="开票价（元）" style="margin-right: 20px;">
            <el-input v-model="form.productInvoicePrice" placeholder="请输入" maxlength="11" show-word-limit></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <el-form-item label="提货价" style="margin-right: 20px;">
            <el-input v-model="form.productBugPrice" placeholder="请输入" maxlength="11" show-word-limit></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <el-form-item label="重量（Kg）" style="margin-right: 20px;">
            <el-input v-model="form.productWeight" placeholder="请输入" maxlength="11" show-word-limit></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <el-form-item label="体积（m3）" style="margin-right: 20px;">
            <el-input v-model="form.productBulk" placeholder="请输入" maxlength="11" show-word-limit></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <el-form-item label="长度（cm)" style="margin-right: 20px;">
            <el-input v-model="form.productLength" placeholder="请输入" maxlength="11" show-word-limit></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <el-form-item label="宽度（cm）" style="margin-right: 20px;">
            <el-input v-model="form.productWidth" placeholder="请输入" maxlength="11" show-word-limit></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <el-form-item label="出货仓库" style="margin-right: 20px;">
            <el-input v-model="form.deliverFromGodown" placeholder="请输入" maxlength="50" show-word-limit></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <el-form-item label="失效日期" style="margin-right: 20px;">
            <el-input v-model="form.expiryDate" placeholder="请输入"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <el-form-item label="售后产品型号" style="margin-right: 20px">
            <el-input v-model="form.productAfterSale" placeholder="请输入"  maxlength="50" show-word-limit></el-input>
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
        id: '',
        productNum: '',
        productModel: '',
        productName: '',
        productCategory: '',
        barCode: '',
        productUnit: '',
        productSize: '',
        productPrice: '',
        productInvoicePrice: '',
        productBugPrice: '',
        productWeight: '',
        productBulk: '',
        productLength: '',
        productWidth: '',
        deliverFromGodown: '',
        expiryDate: '',
        productAfterSale: ''
      },
      tableData: []
    }
  },

  mounted() {
    this.getUser();
  },
  methods: {

    saveUser() {
      console.log(JSON.stringify(this.form));
      this.$http.post(baseURL + "/product/up", this.form).then((res) => {
        console.log(res);
        if (res.code === 0) {
          this.$alert('更新成功', '系统提示', {
            confirmButtonText: '确定',
            callback: action => {
              this.$message({
                type: 'success',
                message: `系统提示: 更新成功`
              });
            }
          });
          this.$router.push('Product');
        } else {
          alert(res.msg);
        }

      }).catch((err) => {
        console.log('err');
      })
    },
    getUser() {
      // alert();
      let Id = Number(this.$route.query.id);
      // alert("跳转到修改用户界面，UserId = " +userId);
      this.$http.post(baseURL + "/product/query", {"id": Id}).then((res) => {
        if (res.code === 0) {
          // alert("成功")
          // console.log('editForm:');
          // console.log(res.userInfo);
          this.form = res.reult;
        } else {
          alert(res.msg);
        }

      }).catch((err) => {
        console.log('err');
      })
    },
    gotoUserPage() {
      this.$router.push('Product');
    }

  }

}


</script>

<style scoped>

</style>
