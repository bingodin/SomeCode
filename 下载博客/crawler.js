/**
function read(prompt) {
    process.stdout.write(prompt + ':');
    process.stdin.resume();
    process.stdin.setEncoding('utf-8');
    process.stdin.on('data', function(chunk) {
      process.stdout.write('output: ' + chunk);
      process.exit();
    });
}

read('input')
**/


var request = require('request'),
    zlib = require('zlib'),
    debug = require('debug')('crawler: ');

function crawler(url,parser){
    function response(err, res, body){
         if(err){
             return console.log(err)
         }

        debug(res.headers['content-encoding'])
        zlib.unzip(body, function(err, buffer) {
            if (err) {
                return console.log(err)
            }
          parser(buffer.toString());

        });
    }
    debug(url)
    request.get({
        headers : {
            'Accept-Encoding' : 'gzip',
            'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64; rv:26.0) Gecko/20100101 Firefox/26.0'
        },
        encoding : null,
        url : url}, response)
}


exports.crawler = crawler

