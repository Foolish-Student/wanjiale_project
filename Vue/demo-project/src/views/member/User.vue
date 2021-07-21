<template>
<div>


<div style="height: 50px; font-size: 30px; color: #606266">子账户管理页</div>
<br>
<br>

        <el-form :model="form" label-width="85px" label-position="left">
            <el-row>
                <el-col :span="6">
                    <el-form-item label="用户名：" style="margin-right: 20px;">
                        <el-input type="textarea" :rows="1" maxlength="255" show-word-limit v-model="form.loginName" placeholder="请输入"></el-input>
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
                    <el-form-item label="角色：">
                        <el-select v-model="form.roleName" placeholder="请选择">
                            <el-option label="总经办" value="总经办"></el-option>
                            <el-option label="生产部" value="生产部"></el-option>
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
                    <el-form-item label="真实姓名：" style="margin-right: 20px;">
                        <el-input maxlength="255" show-word-limit type="textarea" :rows="1" v-model="form.userName" placeholder="请输入"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="6">
                    <el-form-item label="手机号码：" style="margin-right: 20px;">
                        <el-input maxlength="25" show-word-limit type="textarea" :rows="1" v-model="form.mobile" placeholder="请输入"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="6">
                    <el-form-item label="性别：" style="margin-right: 20px;">
                        <el-select v-model="form.sex" placeholder="全部">
                            <el-option label="男" value="男"></el-option>
                            <el-option label="女" value="女"></el-option>
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
            <el-button type="danger" icon="el-icon-delete" @click="delUser">删除</el-button>
            <el-button  type="success" icon="el-icon-check" @click="enableUser">启用</el-button>
            <el-button type="warning" icon="el-icon-close" @click="disableUser">禁用</el-button>
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
                    prop="loginName"
                    label="用户名"
                    width="120">
               
            </el-table-column>
            <el-table-column
                    prop="userName"
                    label="真实姓名"
                    width="120">
            </el-table-column>

            <el-table-column
                    prop="roleName"
                    label="角色"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="sex"
                    label="性别"
                    width="55">
            </el-table-column>
            <el-table-column
                    prop="email"
                    label="电子邮箱"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="mobile"
                    label="手机号码"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="status"  :formatter="formatStatus"
                    label="状态"
                    width="55">
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
                               @click="delSingleUser(scope.row)"></el-button>
                    <el-button type="info" icon="el-icon-setting"
                               size="big"
                               @click="gotoUpdatePage(scope.row)"></el-button>
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
  name: 'User',
    components: {
        

    },

    data(){
        return {
        form: {
            loginName: '',
            userName: '',
            roleName: '',
            sex: '',
            email: '',
            mobile: '',
            status: '',
            page:'',
            limit:''
        },
        checkList: ['水热事业部','热能事业部'],
        addDialogVisible: false,
        tableData: [],
        userIdList: [],
        multipleSelection: [],
         currentPage4: 1,
        totalCount:0,
        pageSize:10,
        dialogVisible:false
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
            alert("查询User")
            console.log('this.form:', this.form)
            this.$http.post(baseURL + "/member/user/list",this.form).then((res) => {
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
            this.$router.push('AddUser');
        },

        gotoEditPage(row){
            console.log(row);
            this.$router.push( {path: "EditUser", query: {id:row.userId }});
        },
        gotoUpdatePage(row)
        {
            console.log(row);
            this.$router.push( {path: "UpdatePassword", query: {id:row.userId }});
        },

        //分配权限
        grantAuthorization(){
            this.dialogVisible = true;
  
        },
        // 分配权限确认按钮
        makesure(){
            alert('分配权限确认按钮');
            var params ={};
    
            console.log('params:');
            console.log(this.checkList);
             console.log(this.userIdList);

            this.dialogVisible = false;
        },

        // 批量删除用户
        delUser(){
            console.log('delUser start ......');

			if(this.multipleSelection.length == 0){
                console.log('delUser ids.length == 0 ......');
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
          });console.log('this.userIdList ......',this.userIdList);

            this.$http.post(baseURL + "/member/user/delete",this.userIdList).then((res) => {
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

        delSingleUser(row){            
        this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$message({
            type: 'success',
            message: '删除成功!'
          });console.log('delSingleUser start ......'+row);
             var singleIdList = [];
             singleIdList.push(row.userId);
             console.log('singleIdList ......',singleIdList);

             this.$http.post(baseURL + "/member/user/delete",singleIdList).then((res) => {
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
            this.userIdList = [];
            val.forEach(row => {
                this.userIdList.push(row.userId);
            })
        },

        // 批量启用用户
        enableUser(){
            console.log('enableUser start ......');

			if(this.multipleSelection.length == 0){
                alert('请选择一条数据记录');
				return ;
			}

            for (var i = 0; i < this.multipleSelection.length; i++) {
                if(this.multipleSelection[i].status == 1){
                    alert('用户名: '+this.multipleSelection[i].userName+'记录已经启用，请去掉勾选');
                    return ;
                }
            }

            console.log('this.userIdList ......',this.userIdList);

            this.$http.post(baseURL + "/member/user/enable",this.userIdList).then((res) => {
                alert('启用成功！');
                 this.queryHandler();
            }).catch((err) => {
                console.log('err');
            })
        },

        // 批量禁用用户
        disableUser(){
           console.log('disableUser start ......');

			if(this.multipleSelection.length == 0){
                alert('请选择一条数据记录');
				return ;
			}

            for (var i = 0; i < this.multipleSelection.length; i++) {
                if(this.multipleSelection[i].status == 2){
                    alert('用户名: '+this.multipleSelection[i].userName+'记录已经禁用，请去掉勾选');
                    return ;
                }
            }

            console.log('this.userIdList ......',this.userIdList);

            this.$http.post(baseURL + "/member/user/disable",this.userIdList).then((res) => {
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
