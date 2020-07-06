<template>
  <el-container id="container" :style="{height:screenHeight + 'px'}">
    <video id="v1" autoplay loop muted>
      <source src="../assets/Ryougi.mp4" type="video/mp4"  />
    </video>
    <el-header height="30%"></el-header>
    <el-main>
      <el-row style="height: 100%">
        <el-col :span="8" :offset="8" class="loginSpace">
          <el-row align="middle" class="titleRow">
            <el-col :span="8" :offset="8">
              <h3 class="loginTitle">登录</h3>
            </el-col>
          </el-row>
          <el-row align="middle">
            <el-col :span="16" :offset="3">
              <el-form ref="form" :model="form" label-width="80px" :rules="rules" status-icon>
                <el-form-item label="用户名" prop="username">
                  <el-input v-model="form.username" suffix-icon="el-icon-user" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                  <el-input v-model="form.password" show-password autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label-width="80px">
                  <el-button type="primary" @click="submitForm('form')" class = "loginBtn">登录</el-button>
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

    export default {
        name: 'container',
        data: function () {
            var validatePass = (rule, value, callback) => {
                var reg = /^(\w)(\w|\d){5,10}$/;
                if (!reg.test(value) ){
                    callback(new Error('密码需字母开头长度6-11'));
                } else {
                    if (this.form.username !== '') {
                        this.$refs.form.validateField('username');
                    }
                    callback();
                }
            };
            var validateUname = (rule, value, callback) => {
                var reg = /^(\w)(\w|\d){5,10}$/;
                if(!reg.test(value)){
                    callback(new Error('用户名需字母开头长度6-11'));
                }else{
                    callback();
                }
            };
            return {
                screenHeight: document.body.clientHeight,

                form:{
                    username: "",
                    password: ""

                },
                rules:{
                    password:[
                        {required:"true",message:'请输入密码',trigger: 'blur'},
                        {validator:validatePass,trigger:'blur'}
                    ],
                    username:[
                        {required:"true",message:'请输入用户名',trigger: 'blur'},
                        {validator:validateUname,trigger: 'blur'}
                    ]
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
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        login(this.form);
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
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
    background-color: rgba(255,255,255,0.8);
  }
  #container{
  }
  .loginBtn{
    width: 100%;
  }
  video{
    position: fixed;
    right: 0px;
    min-width: 100%;
    min-height: 100%;
    height: 100%;
    width: 100%;
    /*加滤镜*/
    /*filter: blur(15px);
    -webkit-filter: grayscale(100%);
    filter:grayscale(10%);*/
    z-index:-11;
    object-fit:fill;
  }
  source{
    min-width: 100%;
    min-height: 100%;
    height: 100%;
    width: 100%;
  }


</style>
