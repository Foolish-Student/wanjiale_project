<template>
    <el-container>
        <el-header height="70px">
            <div class="title1">万家乐OCP系统 <span class="title2">经销商平台</span></div>
        </el-header>
        <el-container id="app">
            <el-aside width="200px">
                <nav-menu></nav-menu>
            </el-aside>
            <el-main>
                <router-view/>
            </el-main>
        </el-container>
    </el-container>
</template>
<script>
    import NavMenu from "./components/NavMenu";

    export default {
        name: 'App',
        components: {NavMenu}
    }
</script>
<style>
    html, body {
        height: 100%;
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    #app {
        font-family: Avenir, Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: left;
        width: 100%;
        height: 100%;
    }

    .title1 {
        font-size: 35px;
        font-weight: bold;
        letter-spacing: 3px;
        color: #fa0304;
        margin: 10px 40px;

        display: inline-block;
    }

    .title2 {
        font-size: 22px;
    }

    .el-header{
        background-color: #fff;
        color: #fff;
        border-bottom: 1px #cdcdcd solid;
    }

    .el-aside {
        color: #333;
        text-align: center;
    }

    body > .el-container {
        margin-bottom: 40px;
    }
</style>
