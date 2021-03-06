import Vue from 'vue'
import Router from 'vue-router'
import login from '@/components/login'
import mainpage from '@/components/mainpage'
import chat from '@/pages/Chat/chat'
import fileDownload from '@/pages/file/file'
import download from '@/pages/file/download'
import upload from '@/pages/file/upload'
import voicechat from "@/pages/VoiceChat/voicechat";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: login
    },
    {
      path:'/main',
      name:'main',
      component:mainpage,
      redirect:'/main/chat',
      children:[
        {
          path:'chat',
          component:chat,
        },
        {
          path:'file',
          component:fileDownload,
          redirect:'/main/file/download',
          children:[
            {
              path:'download',
              component:download,
            },
            {
              path:'upload',
              component:upload,
            }
          ],
        },
        {
          path: 'voiceChat',
          component: voicechat
        }
      ],
    }
  ]
})
