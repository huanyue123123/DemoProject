<template>
  <el-container id="container" :style="{height:screenHeight + 'px'}">
    <el-header height="20%"></el-header>
    <el-main>
      <el-row style="height: 100%">
        <el-col :span="8" :offset="8" class="loginSpace">
          <el-row align="middle" class="titleRow">
            <el-col :span="8" :offset="8">
              <h3 class="loginTitle">登录</h3>
            </el-col>
          </el-row>
          <el-row align="middle">
            <el-col :span="16" :offset="4">
              <el-form ref="form" :model="form" label-width="80px">
                <el-form-item label="用户名">
                  <el-input v-model="form.username" suffix-icon="el-icon-user"></el-input>
                </el-form-item>
                <el-form-item label="密码">
                  <el-input v-model="form.password" show-password></el-input>
                </el-form-item>
                <el-form-item>
                  <el-button type="primary" @click="onSubmit">立即创建</el-button>
                  <el-button>取消</el-button>
                </el-form-item>
              </el-form>
            </el-col>
          </el-row>


        </el-col>
      </el-row>
    </el-main>
    <el-footer height="10%"></el-footer>
  </el-container>
</template>
<script>
    import {login} from '../js/login';

    var user = {"username": "1", "password": "1"}
    console.log(login(user))
    export default {
        name: 'container',
        data: function () {
            return {
                screenHeight: document.body.clientHeight,

                form:{
                    username: "",
                    password: "",
                }
            }
        },
        mounted() {
            const that = this
            window.onresize = () => {
                return (() => {
                    window.screenHeight = document.body.clientHeight
                    that.screenHeight = window.screenHeight
                })()
            }
        },
        watch: {
            screenHeight(val) {
                // 为了避免频繁触发resize函数导致页面卡顿，使用定时器
                if (!this.timer) {
                    // 一旦监听到的screenWidth值改变，就将其重新赋给data里的screenWidth
                    this.screenHeight = val
                    this.timer = true
                    let that = this
                    setTimeout(function () {
                        // 打印screenWidth变化的值
                        that.timer = false
                    }, 400)
                }
            }
        },
        methods:{
            onSubmit(){
                console.log("onSubmit!!!");
            }
        }
    }

</script>
<style>
  .titleRow {
  }

  .des {
    line-height: 30px;
  }

  .loginSpace {
    height: 100%;
  }


</style>
