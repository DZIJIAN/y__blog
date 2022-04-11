import request from '@/request'

export function publishMessage(message) {
  return request({
    url: `/message`,
    method: 'post',
    data: message,
    contentType: "application/json;charset=UTF-8"
  })
}

export function listMessage() {
  return request({
    url: `/message/list`,
    method: 'get',
  })
}
