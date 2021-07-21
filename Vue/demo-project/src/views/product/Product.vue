<template>
  <div>
    <div style="height: 50px; font-size: 30px; color: #606266">产品信息查询</div>
    <el-form :model="form" label-width="85px" label-position="left">
      <el-row>
        <el-col :span="6">
          <el-form-item label="产品编码：" style="margin-right: 20px;">
            <el-input v-model="form.productNum" placeholder="请输入" maxlength="50" show-word-limit></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="产品名称：" style="margin-right: 20px;margin-left: 30px">
            <el-input v-model="form.productName" placeholder="请输入" maxlength="50" show-word-limit></el-input>
          </el-form-item>
        </el-col>

      </el-row>
      <el-row>
        <el-col :span="6">
          <el-form-item label="类目：">
            <el-select v-model="form.productCategory" placeholder="请选择">
              <el-option label="热水电商" value="热水电商"></el-option>
              <el-option label="厨房电商" value="厨房电商"></el-option>
            </el-select>
          </el-form-item>
        </el-col>

        <el-col :span="6">
          <el-form-item label="产品型号：" style="margin-right: 20px;margin-left: 30px">
            <el-input v-model="form.productModel" placeholder="请输入" maxlength="50" show-word-limit></el-input>
          </el-form-item>
        </el-col>

        <el-col :span="6">
          <el-button type="primary" @click="queryHandler">查询</el-button>
          <el-button  type="primary" @click="reset">重置</el-button>
        </el-col>
      </el-row>
    </el-form>

    <div style="text-align: left">
      <el-button type="primary"
                 icon="el-icon-circle-plus" @click="gotoAddPage">新增
      </el-button>
      <el-button type="primary" icon="el-icon-delete" @click="delall">删除</el-button>
    </div>

    <el-table
        ref="multipleTable"
        :data="tableData"
        tooltip-effect="dark"
        style="width: 100%" @selection-change="handleSelectionChange">
      style="width: 100%">
      <el-table-column
          type="selection"
          width="55">
      </el-table-column>
      <el-table-column label="序号"
                       type="index"
                       width="55">
      </el-table-column>
      <el-table-column
          prop="productNum"
          label="产品编码"
          width="120">
      </el-table-column>
      <el-table-column
          prop="productModel"
          label="产品型号"
          width="120">
      </el-table-column>

      <el-table-column
          prop="productName"
          label="产品名称"
          width="120">
      </el-table-column>
      <el-table-column
          prop="productCategory"
          label="类目"
          width="120">
      </el-table-column>
      <el-table-column
          prop="barCode"
          label="条形码"
          width="120">
      </el-table-column>
      <el-table-column
          prop="productUnit"
          label="单位"
          width="120">
      </el-table-column>
      <el-table-column
          prop="productSize"
          label="规格"
          width="120">
      </el-table-column>
      <el-table-column
          prop="productPrice"
          label="零售价（元）"
          width="120">
      </el-table-column>
      <el-table-column
          prop="productInvoicePrice"
          label="开票价（元）"
          width="120">
      </el-table-column>

      <el-table-column label="操作" align="center" min-width="15%">
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" circle
                     size="small"
                     @click="up(scope.row)"></el-button>
          <el-button type="danger" icon="el-icon-delete" circle
                     size="small"
                     @click="open(scope.row)"></el-button>
          <el-button type="info" icon="el-icon-document" circle
                     size="small"
                     @click="info(scope.row)"></el-button>
        </template>
      </el-table-column>
    </el-table>

    <div class="block" style="float:right;">
      <!-- <span class="demonstration">完整功能</span> -->
      <el-pagination
          background

          :pager-count="11"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage4"
          :page-sizes="[3,5,10, 20, 50, 100]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="totalCount">
      </el-pagination>
    </div>
  </div>
</template>

<script>

export default {
  name: 'Home',
  components: {},


  data() {
    return {
      form: {
        productNum: '',
        productName: '',
        productCategory: '',
        productModel: ''
      },
      tableData: [],
      produceIdList: [],
      multipleSelection: [],
      currentPage4: 1,
      totalCount:0,
      pageSize: 10,
      dialogVisible:false
    }
  },
  mounted() {
    this.queryHandler();
  },
  methods: {
    open(row) {
      this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$message({
          type: 'success',
          message: '删除成功!',
        });
        var singleIdList = [];
        singleIdList.push(row.id);
        this.$http.post(baseURL + "/product/del", singleIdList).then((res) => {
          this.queryHandler();
        }).catch((err) => {
          console.log('err');
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },

    queryHandler() {
      this.$http.post(baseURL + "/product/list", this.form).then((res) => {
        this.tableData = res.page.list;
        this.tableData = res.page.list;
        this.totalCount = res.page.totalCount;
        this.pageSize = res.page.pageSize;
      }).catch((err) => {
        console.log('err');
      })
    },
    delall() {
      this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$message({
          type: 'success',
          message: '删除成功!'
        });
        console.log('delUser start ......');
        if (this.multipleSelection.length == 0) {
          alert('请选择一条数据记录');
          return;
        }
        this.$http.post(baseURL + "/product/del", this.produceIdList).then((res) => {
          console.log(res);
          this.queryHandler();
          this.$router.push('Product');
        }).catch((err) => {
          console.log('err');
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    reset(){
      this.form = {};
    },

    // 获取选中的数据
    handleSelectionChange(val) {
      console.log(val)
      this.multipleSelection = val;
      this.produceIdList = [];
      val.forEach(row => {
        this.produceIdList.push(row.id);
      })
    },
    gotoAddPage() {
      this.$router.push('AddProduct');
    },
    up(row) {
      this.$router.push({path: 'UpProduct', query: {id: row.id}});
    },
    info(row) {
      this.$router.push({path: 'Info', query: {id: row.id}});
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.form.limit =  val;
      this.queryHandler();
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.form.page =  val;
      this.queryHandler();
    },


  }
}
</script>

<style>
.home {
  width: 100%;
  height: 100%;
}
</style>
