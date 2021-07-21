<template>
    <div>
<div style="height: 50px; font-size: 30px; color: #606266; text-align: center;font-size: 40px"><h1>万家乐项目主页</h1></div>
      <div style="position:absolute; bottom:80px; right: 280px;">
        <h3 style="color: #606266">软件1191 李万</h3>
        <h3 style="color: #606266">软件1197 张会钦</h3>
      </div>
<!--        <el-form :model="form" label-width="85px" label-position="left">-->
<!--            <el-row>-->
<!--                <el-col :span="6">-->
<!--                    <el-form-item label="用户名：" style="margin-right: 20px;">-->
<!--                        <el-input v-model="form.name" placeholder="请输入"></el-input>-->
<!--                    </el-form-item>-->
<!--                </el-col>-->
<!--                <el-col :span="6">-->
<!--                    <el-form-item label="状态：" style="margin-right: 20px;">-->
<!--                        <el-select v-model="form.region" placeholder="请选择">-->
<!--                            <el-option label="区域一" value="shanghai"></el-option>-->
<!--                            <el-option label="区域二" value="beijing"></el-option>-->
<!--                        </el-select>-->
<!--                    </el-form-item>-->
<!--                </el-col>-->
<!--                <el-col :span="6">-->
<!--                    <el-form-item label="角色：">-->
<!--                        <el-select v-model="form.region" placeholder="请选择">-->
<!--                            <el-option label="区域一" value="shanghai"></el-option>-->
<!--                            <el-option label="区域二" value="beijing"></el-option>-->
<!--                        </el-select>-->
<!--                    </el-form-item>-->
<!--                </el-col>-->
<!--            </el-row>-->
<!--            <el-row>-->
<!--                <el-col :span="6">-->
<!--                    <el-form-item label="真实姓名：" style="margin-right: 20px;">-->
<!--                        <el-input v-model="form.realname" placeholder="请输入"></el-input>-->
<!--                    </el-form-item>-->
<!--                </el-col>-->
<!--                <el-col :span="6">-->
<!--                    <el-form-item label="手机号码：" style="margin-right: 20px;">-->
<!--                        <el-input v-model="form.mobile" placeholder="请输入"></el-input>-->
<!--                    </el-form-item>-->
<!--                </el-col>-->
<!--                <el-col :span="6">-->
<!--                    <el-form-item label="性别：" style="margin-right: 20px;">-->
<!--                        <el-select v-model="form.region" placeholder="全部">-->
<!--                            <el-option label="男" value="shanghai"></el-option>-->
<!--                            <el-option label="女" value="beijing"></el-option>-->
<!--                        </el-select>-->
<!--                    </el-form-item>-->
<!--                </el-col>-->
<!--                <el-col :span="6">-->
<!--                    <el-button @click="queryHandler">查询</el-button>-->
<!--                </el-col>-->
<!--            </el-row>-->


<!--        </el-form>-->


<!--        <div style="text-align: left">-->
<!--            <el-button type="primary"-->
<!--                       icon="el-icon-circle-plus" @click="gotoAddPage">新增</el-button>-->
<!--            <el-button>分配权限</el-button>-->
<!--            <el-button icon="el-icon-delete">删除</el-button>-->
<!--            <el-button>启用</el-button>-->
<!--            <el-button>禁用</el-button>-->
<!--        </div>-->

<!--        <el-table-->
<!--                ref="multipleTable"-->
<!--                :data="tableData"-->
<!--                tooltip-effect="dark"-->
<!--                style="width: 100%">-->
<!--            <el-table-column-->
<!--                    type="selection"-->
<!--                    width="55">-->
<!--            </el-table-column>-->
<!--            <el-table-column label="序号"-->
<!--                             type="index"-->
<!--                             width="55">-->
<!--            </el-table-column>-->
<!--            <el-table-column-->
<!--                    label="用户名"-->
<!--                    width="120">-->
<!--                <template slot-scope="scope">{{ scope.row.date }}</template>-->
<!--            </el-table-column>-->
<!--            <el-table-column-->
<!--                    prop="name"-->
<!--                    label="真实姓名"-->
<!--                    width="120">-->
<!--            </el-table-column>-->

<!--            <el-table-column-->
<!--                    prop="name"-->
<!--                    label="角色"-->
<!--                    width="120">-->
<!--            </el-table-column>-->
<!--            <el-table-column-->
<!--                    prop="name"-->
<!--                    label="性别"-->
<!--                    width="120">-->
<!--            </el-table-column>-->
<!--            <el-table-column-->
<!--                    prop="name"-->
<!--                    label="电子邮箱"-->
<!--                    width="120">-->
<!--            </el-table-column>-->
<!--            <el-table-column-->
<!--                    prop="name"-->
<!--                    label="手机号码"-->
<!--                    width="120">-->
<!--            </el-table-column>-->
<!--            <el-table-column-->
<!--                    prop="address"-->
<!--                    label="状态"-->
<!--                    width="120">-->
<!--            </el-table-column>-->

<!--            <el-table-column label="操作" align="center" min-width="15%" >-->
<!--                <template slot-scope="scope">-->
<!--                    <el-button icon="el-icon-download" size="small"-->
<!--                               @click=""></el-button>-->
<!--                    <el-button icon="el-icon-delete"-->
<!--                               size="small"-->
<!--                               @click=""></el-button>-->
<!--                </template>-->
<!--            </el-table-column>-->
<!--        </el-table>-->
    </div>
</template>

<script>
// @ is an alias to /src
// import NavMenu from  "../components/NavMenu";

export default {
  name: 'Home',
  components: {

  },
    data(){
      return {
        form: {
            name: '',
            realname: '',
            mobile: ''
        },
          tableData: [{
              date: '2016-05-03',
              name: '王小虎',
              address: '上海市普陀区金沙江路 1518 弄'
          }, {
              date: '2016-05-02',
              name: '王小虎',
              address: '上海市普陀区金沙江路 1518 弄'
          }, {
              date: '2016-05-04',
              name: '王小虎',
              address: '上海市普陀区金沙江路 1518 弄'
          }, {
              date: '2016-05-01',
              name: '王小虎',
              address: '上海市普陀区金沙江路 1518 弄'
          }, {
              date: '2016-05-08',
              name: '王小虎',
              address: '上海市普陀区金沙江路 1518 弄'
          }, {
              date: '2016-05-06',
              name: '王小虎',
              address: '上海市普陀区金沙江路 1518 弄'
          }, {
              date: '2016-05-07',
              name: '王小虎',
              address: '上海市普陀区金沙江路 1518 弄'
          }]
      }
    },
    mounted(){

    },
    methods: {

        queryHandler(){
            alert("查询Home")
        },
        gotoAddPage(){
            this.$router.push('Add');
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
