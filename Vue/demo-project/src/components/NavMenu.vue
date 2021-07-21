<template>
    <el-menu style="height:100%;">
        <el-submenu index="1">
            <template slot="title">
                <i class="el-icon-location"></i>
                <span style="">订单管理 *</span>
            </template>
            <el-menu-item-group>
                <el-menu-item index="1-1">提交订单 *</el-menu-item>
                <el-menu-item index="1-2">待处理订单 *</el-menu-item>
            </el-menu-item-group>
        </el-submenu>
        <el-submenu index="2">
            <template slot="title">
                <i class="el-icon-location"></i>
                <span>产品管理</span>
            </template>
            <el-menu-item-group>
                <el-menu-item index="1-1" @click="gotoproduct">产品信息查询</el-menu-item>
                
            </el-menu-item-group>
        </el-submenu>

        <el-submenu index="3">
            <template slot="title">
                <i class="el-icon-location"></i>
                <span>会员信息</span>
            </template>
            <el-menu-item-group>
                <el-menu-item index="1-1" style="" @click="gotoUserPage">子账号管理</el-menu-item>
                <el-menu-item index="1-2" @click="gotoRolePage">角色管理</el-menu-item>
            </el-menu-item-group>
        </el-submenu>

        <el-submenu index="4">
            <template slot="title">
                <i class="el-icon-location"></i>
                <span>网店设置</span>
            </template>
            <el-menu-item-group>
                <el-menu-item index="1-1" @click="setShop">网店设置</el-menu-item>

            </el-menu-item-group>
        </el-submenu>
    </el-menu>
</template>

<script>
    export default {
        name: "NavMenu",
        components: {

        },
        mounted(){

        },
        methods: {

            queryHandler(){
                alert("查询Home")
            },
            gotoUserPage(){
                this.$router.push('User');
            },
            gotoRolePage(){
                this.$router.push('Role');
            },
          gotoproduct() {
            // alert("执行了");
            this.$router.push('Product');
          },
            gotoPwdPage(){
                this.$router.push('Pwd');
            },
            setShop(){
                this.$router.push("Shop");
            }

        }
    } 
</script>

<style scoped>

</style>
