<template>
  <div>
    <div style="height: 50px; font-size: 30px; color: #606266">网点设置管理</div>


    <div style="text-align: left">
      <el-button type="primary" icon="el-icon-circle-plus" @click="gotoAddPage">新增</el-button>
      <el-button type="primary" icon="el-icon-delete" @click="delall">删除</el-button>
      <el-button type="primary" icon="el-icon-check" @click="start">启用</el-button>
      <el-button type="primary" icon="el-icon-close" @click="stop">禁用</el-button>
    </div>

    <el-table
        ref="multipleTable"
        :data="tableData"
        tooltip-effect="dark"
        style="width: 100%" @selection-change="handleSelectionChange">
      <el-table-column
          type="selection"
          width="70px">
      </el-table-column>
      <el-table-column label="序号"
                       type="index"
                       width="55">
      </el-table-column>
      <el-table-column
          label="网店平台类别"
          prop="shopCategory"
          width="120">

      </el-table-column>
      <el-table-column
          prop="shopUrl"
          label="网址"
          width="200">
      </el-table-column>

      <el-table-column
          prop="account"
          label="账号"
          width="120">
      </el-table-column>
      <el-table-column
          prop="password"
          label="密码"
          width="120">
      </el-table-column>
      <el-table-column
          prop="status" :formatter="formatStatus"
          label="状态"
          width="120">
      </el-table-column>
      <el-table-column
          prop="updateTime"
          label="修改时间"
          width="300">
      </el-table-column>
      <el-table-column
          prop="updateBy"
          label="修改人"
          width="120">
      </el-table-column>

      <el-table-column label="操作" align="center" min-width="15%">
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" circle
                     size="small"
                     @click="update(scope.row)"></el-button>
          <el-button type="danger" icon="el-icon-delete" circle
                     size="small"
                     @click="open(scope.row)"></el-button>
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
// @ is an alias to /src
// import NavMenu from  "../components/NavMenu";

export default {
  name: 'Home',
  components: {},
  data() {
    return {
      form: {
        name: '',
        realname: '',
        mobile: ''
      },
      tableData: [],
      shopIdList: [],
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


    queryHandler() {
      console.log('this.form:', this.form)
      this.$http.post(baseURL + "/list", this.form).then((res) => {
        console.log(res);

        this.tableData = res.page.list;
        this.tableData = res.page.list;
        this.totalCount = res.page.totalCount;
        this.pageSize = res.page.pageSize;

      }).catch((err) => {
        console.log('err');
      })
    },
    gotoAddPage() {
      this.$router.push('AddShop');
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
        if (this.multipleSelection.length == 0) {
          alert('请选择一条数据记录');
          return;
        }
        this.$http.post(baseURL + "/store/del", this.shopIdList).then((res) => {
          console.log(res);
          this.queryHandler();
          this.$router.push('Shop');
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

    open(row) {
      this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$message({
          type: 'success',
          message: '删除成功!'
        });
        var singleIdList = [];
        singleIdList.push(row.shopId);
        this.$http.post(baseURL + "/store/del", singleIdList).then((res) => {
          this.queryHandler();
        }).catch((err) => {
          console.log('err');
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },

    start() {
      if (this.multipleSelection.length == 0) {
        alert('请选择一条数据记录');
        return;
      }
      this.$http.post(baseURL + "/store/start", this.shopIdList).then((res) => {
        console.log(res);
        this.queryHandler();
      }).catch((err) => {
        console.log('err');
      })
    },
    stop() {
      if (this.multipleSelection.length == 0) {
        alert('请选择一条数据记录');
        return;
      }
      this.$http.post(baseURL + "/store/stop", this.shopIdList).then((res) => {
        console.log(res);
        this.queryHandler();
      }).catch((err) => {
        console.log('err');
      })
    },

    update(row) {
      this.$router.push({path: 'UpDate', query: {id: row.shopId}});
    },

    // 获取选中的数据
    handleSelectionChange(val) {
      console.log(val)
      this.multipleSelection = val;
      this.shopIdList = [];
      val.forEach(row => {
        this.shopIdList.push(row.shopId);
      })
    },
    //角色转换
    formatStatus: function (row, column) {
      return row.status == '1' ? "启用" : row.status == '0' ? "禁用" : "空";
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
