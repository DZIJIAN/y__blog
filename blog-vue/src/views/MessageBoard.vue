<template>

      <el-card class="el-card-d" shadow="always">
        <div class="infinite-list-wrapper" style="overflow:auto;">
          <el-timeline
            infinite-scroll-disabled="disabled" :reverse="false">
            <div v-if="allmessages.length>0">
              <el-timeline-item v-for="(item,index) in allmessages"  :key="index" :timestamp='item.createDate' placement="top">
                <el-card class="el-card-m" style="height:80px">
                  <h4>{{item.memberName}}：</h4>
                  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{item.content}}</p>
                </el-card>
              </el-timeline-item>
            </div>
            <div v-else>
              <el-timeline-item placement="top">
                <el-card class="el-card-m" style="height:120px">
                  <h4>大黄子：</h4>
                  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 说点什么吧😁</p>
                </el-card>
              </el-timeline-item>
            </div>
          </el-timeline>
        </div>
        <div>
          昵称:<input v-model="message.memberName" placeholder="请输入昵称，默认为游客" style="border-width: 2px"></input>
        </div>
        <div class="el-card-messages">
          <el-input type="textarea" :rows="5" placeholder="输入留言" maxlength="200" v-model="message.content"></el-input>
          <el-button type="info" round class="submit-message" @click="submitMessage">留言</el-button>
        </div>
      </el-card>

</template>

<script>
import {listMessage, publishMessage} from "../api/message";

  export default {
    name: 'MessageBoard',
    data() {
      return {
        message: {
          content:"",
          memberName:""
        },
        allmessages:[]
      }
    },
    computed: {
      title (){
        return '留言板 - Y博园'
      }
    },
    methods:{
      submitMessage(){
        if(this.message.content=='' || this.message.content.replace(/(^\s*)|(\s*$)/g, "")==""){
          this.$message('写点啥提交也行呀😉');
          return;
        }
        if(this.message.memberName == null){
          this.message.memberName = "游客";
        }
         //调用后端的代码
        let that = this
        publishMessage(this.message).then(data=>{
          if(data.success){
            that.$message({type: 'success', message: '留言成功', showClose: true})
            this.showMessageBoard();
          }else{
            that.$message({type: 'error', message: data.msg, showClose: true})
          }
        }).catch(error => {
          if (error !== 'error') {
            that.$message({type: 'error', message: '留言失败', showClose: true})
          }
        })
      },
      showMessageBoard(){
        let that = this;
        listMessage().then(data=>{
          console.log(data);
          that.allmessages = data.data
        })
      }
    },
    mounted() {
      this.showMessageBoard()
    }
  }
</script>

<style scoped>
.infinite-list-wrapper{
  width: 100%;
  height: 500px;
}

.submit-message{
  width: 100%;
  background: rgb(235, 245, 247);
  color: cadetblue;
  letter-spacing:20px;
}

</style>
