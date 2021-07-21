<template>
<div>


<div style="height: 50px; font-size: 30px; color: #606266">角色管理页</div>
<br>
<br>

        <el-form :model="form" label-width="85px" label-position="left">
            <el-row>
                <el-col :span="6">
                    <el-form-item label="角色名称：" style="margin-right: 20px;">
                        <el-input maxlength="255" show-word-limit v-model="form.roleName" placeholder="请输入"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="6">
                    <el-form-item label="状态：" style="margin-right: 20px;">
                        <el-select v-model="form.status" placeholder="请选择">
                            <el-option label="启用" value="1"></el-option>
                            <el-option label="禁用" value="2"></el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :span="6">
                    <el-button-group>
                    <el-button type="primary" icon="el-icon-search" @click="queryHandler">查询</el-button>
                    <el-button  type="warning" @click="reset">重置</el-button>
                    </el-button-group>
                </el-col>
            </el-row>


        </el-form>

        <div style="text-align: left">
            <el-button-group>
            <el-button type="primary" icon="el-icon-circle-plus" @click="gotoAddPage">新增</el-button>
            <el-button type="danger" icon="el-icon-delete" @click="delRole">删除</el-button>
            <el-button  type="success" icon="el-icon-check" @click="enableRole">启用</el-button>
            <el-button type="warning" icon="el-icon-close" @click="disableRole">禁用</el-button>
            </el-button-group>
        </div>

        <el-table
                ref="multipleTable"
                :data="tableData"
                tooltip-effect="dark"
                style="width: 100%" @selection-change="handleSelectionChange">
            <el-table-column
                    type="selection"
                    width="55">
            </el-table-column>
            <el-table-column label="序号"
                             type="index"
                             width="55">
            </el-table-column>
            <el-table-column
                    prop="roleName"
                    label="角色名称"
                    width="120">
               
            </el-table-column>
            <el-table-column
                    prop="status"  :formatter="formatStatus"
                    label="状态"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="roleRemark"
                    label="角色描述"
                    width="300">
            </el-table-column>
            <el-table-column
                    prop="updateTime"
                    label="修改时间"
                    width="150">
            </el-table-column>
            <el-table-column label="操作" align="center" min-width="15%" >
                <template slot-scope="scope">
                    <el-button-group>
                    <el-button type="primary" icon="el-icon-edit" size="big"
                                @click="gotoEditPage(scope.row)"></el-button>
                    <el-button type="danger" plain icon="el-icon-delete"
                               size="big"
                               @click="delSingleRole(scope.row)"></el-button>
                    </el-button-group>
                </template>
            </el-table-column>
        </el-table>
 <div class="block" style="float:right">
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
//import EditUser from '../member/EditUser.vue'


var baseURL = "http://localhost:8081/data-wanjiale";
export default {
  name: 'Role',
    components: {
        

    },

    data(){
        return {
        form: {
            roleName: '',
            status: '',
            page:'',
            limit:''
        },
        tableData: [],
        roleIdList: [],
        multipleSelection: [],
        currentPage4: 1,
        totalCount:0,
        pageSize:10
        }
    },

    mounted(){
        this.queryHandler();
    },
    methods: {
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

        queryHandler(){
            alert("查询Role列表页面")
            //console.log('http:', this.$http)
            console.log('this.form:', this.form)
            this.$http.post(baseURL + "/member/role/list",this.form).then((res) => {
                console.log(res);
                this.tableData = res.page.list;
                this.totalCount = res.page.totalCount;
                this.pageSize = res.page.pageSize;
            }).catch((err) => {
                console.log('err');
            })
        },

        reset(){
            this.form = {};
        },

        gotoAddPage(){
            this.$router.push('AddRole');
        },

       gotoEditPage(row){
            console.log(row);
            this.$router.push( {path: "EditRole", query: {id:row.roleId}});
        },
        // 批量删除用户
        delRole(){
            console.log('delRole start ......');

			if(this.multipleSelection.length == 0){
                console.log('delRole ids.length == 0 ......');
                alert('请选择一条数据记录');
				return ;
			}
            this.$confirm('此操作将永久删除你所选择的文件, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$message({
            type: 'success',
            message: '删除成功!'
          });console.log('this.roleIdList ......',this.roleIdList);

            this.$http.post(baseURL + "/member/role/delete",this.roleIdList).then((res) => {
                 console.log(res);
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

        delSingleRole(row){
             this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$message({
            type: 'success',
            message: '删除成功!'
          });console.log('delSingleRole start ......'+row);
            var singleIdList = [];
            singleIdList.push(row.roleId);
            console.log('singleIdList ......',singleIdList);

            this.$http.post(baseURL + "/member/role/delete",singleIdList).then((res) => {
                // alert('删除数据记录成功');
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

        // 获取选中的数据
        handleSelectionChange(val) {
            console.log(val)
            this.multipleSelection = val;
            this.roleIdList = [];
            val.forEach(row => {
                this.roleIdList.push(row.roleId);
            })
        },

        // 批量启用角色
        enableRole(){
            console.log('enableRole start ......');

			if(this.multipleSelection.length == 0){
                alert('请选择一条数据记录');
				return ;
			}

            for (var i = 0; i < this.multipleSelection.length; i++) {
                if(this.multipleSelection[i].status == 1){
                    alert('用户名: '+this.multipleSelection[i].roleName+'记录已经启用，请去掉勾选');
                    return ;
                }
            }

            console.log('this.roleIdList ......',this.roleIdList);

            this.$http.post(baseURL + "/member/role/enable",this.roleIdList).then((res) => {
                alert('启用成功！');
                 this.queryHandler();
            }).catch((err) => {
                console.log('err');
            })
        },

        // 批量禁用角色
        disableRole(){
           console.log('disableRole start ......');

			if(this.multipleSelection.length == 0){
                alert('请选择一条数据记录');
				return ;
			}

            for (var i = 0; i < this.multipleSelection.length; i++) {
                if(this.multipleSelection[i].status == 2){
                    alert('角色名: '+this.multipleSelection[i].roleName+'记录已经禁用，请去掉勾选');
                    return ;
                }
            }

            console.log('this.roleIdList ......',this.roleIdList);

            this.$http.post(baseURL + "/member/role/disable",this.roleIdList).then((res) => {
                alert('禁用成功！');
                 this.queryHandler();
            }).catch((err) => {
                console.log('err');
            })
        },

        //角色转换
        formatStatus: function(row, column) {
            return row.status == '1' ? "启用" : row.status == '2' ? "禁用" : "空";
        }

    }
}
</script>

<style>
    .home{
        width: 100%;
        height: 100%;
    }
</style>
