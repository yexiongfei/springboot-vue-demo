/**
 * axios请求封装
 *
 * @param {*} url
 * @param {*} json
 * @param {string} [method='post']
 * @param {number} [timeout=25000]
 * @returns
 */
function fetch (url, json, method = 'post', timeout = 25000) {
  var promise = new Promise((resolve, reject) => {
    let req = {
      url: url,
      method: method,
      data: json,
      timeout: timeout,
      headers: { 'Accept': 'application/json', 'Content-Type': 'application/json'}
    }
    axios(req)
      .then((response) => {
        let res = response.data
        if (res.code === 200) {
          resolve(res.data)
        } else if (res.code === 300) {
          window.vm.$message.error(res.msg)
          window.location.href = "/"
        } else {
          window.vm.$message.error(res.msg)
          reject(res.msg)
        }
      })
      .catch((error) => {
        console.error(`ajax error: ${url} ### ${error}`)
        if (error.message) {
          reject(error.message)
        } else {
          reject(new Error(`ajax 异常: ${url}`))
        }
      })
  })

  return promise
}



function post($vue, url, params, callback) {
    axios.post(url, params).then(function(res) {
        if(res.data.code === 200) {
           callback(res.data);
        }else if(res.data.code == 300) {
            $vue.$message.error('请重新登录')
            window.location.href = "/"
        } else {
          $vue.$message.error(res.data.msg);
        }
    }).
    catch(function(error) {
        $vue.$message.error("后台服务器异常");
    });

}
