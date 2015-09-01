/**
 * Created by youxiachai on 14-1-20.
 */
var request = require('request'),
    cheerio = require('cheerio'),
    debug = require('debug')('parse: article')
	crawler = require('./crawler');


function parseItem($item){

    var a = $item.find('a')
    var text =  a.text()
	var herf =  a.attr("href")

    console.log("<h1>" +text + "<h1>")
    crawler.crawler(herf,parseArticle)


}
function parseArticleTopic(html){

    var  $ = cheerio.load(html);
    // 获取list

    var $list = $('.list-group');

    $list.children().each(function (){
        parseItem(cheerio(this))
    })
}
function parseArticle(html){
    var  $ = cheerio.load(html);
    var $body = $('body');
	console.log($body.toString())
	console.log('<h1>=======================================================<h1>')
 
}

exports.parseArticleTopic = parseArticleTopic