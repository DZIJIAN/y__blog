<template>
  <el-card>
    <h1 class="me-author-name">Y博园</h1>
    <div class="me-author-description">
      <span><i class="el-icon-location-outline"></i> &nbsp;江西&赣州</span>
      <span><i class="me-icon-job"></i> &nbsp;编程终身学习者</span>
    </div>
    <div class="me-author-tool">
      <i @click="showTool(qq)" :title="qq.title" class="iconfont icon-qq"></i>
      <i @click="showTool(gitee)" :title="gitee.title" class="gitee"></i>
<!--      <i @click="showTool(bilibili)" :title="bilibili.title" class="iconfont icon-bilibili-fill"></i>-->
    </div>
  </el-card>

</template>

<script>
  export default {
    name: 'CardMe',
    data() {
      return {
        qq: {title: 'QQ', message: '337943524'},
        gitee: {
          title: '码云',
          message: '<a target="_blank" href="https://gitee.com/qingtianyouzai">https://gitee.com/qingtianyouzai</a>'
        }
      }
    },
    methods: {
      showTool(tool) {
        this.$message({
          duration: 2000,
          showClose: true,
          dangerouslyUseHTMLString: true,
          message: '<strong>' + tool.message + '</strong>'
        });
      }
    }
  }
</script>

<style scoped>
  .me-author-name {
    text-align: center;
    font-size: 30px;
    border-bottom: 1px solid #1a1818;
  }

  .me-author-description {
    padding: 8px 0;
  }

  .me-icon-job {
    padding-left: 16px;
  }

  .me-author-tool {
    text-align: center;
    padding-top: 10px;
  }

  .me-author-tool i {
    cursor: pointer;
    padding: 4px 10px;
    font-size: 30px;
  }

  .gitee {
    display:inline-block;
    /*cursor: pointer;*/
    height: 18px;
    width: 10px;
    background-image: url(../../assets/icon/GITEE.png);
    background-size: cover;
  }
</style>
