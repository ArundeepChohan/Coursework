var express = require('express');   
var mongoose = require('mongoose');
var http =require('http');
var app = express();   
var path = require('path');          
var fs = require('fs');
var bodyParser = require('body-parser');
var Login = require('./lib/Login');
var House = require('./lib/House');
var url='mongodb://localhost/test';
var assert = require('assert');

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));
app.use('/', express.static(path.join(__dirname, 'public')));
//view engine setup

app.set('port',process.env.PORT || 8080);

mongoose.connect(url);


var login1 =new Login({username:'admin',password:'admin',permission:1});
login1.save();

var login3 =new Login({username:'user',password:'user',permission:3})
login3.save();

var login2 =new Login({username:'subscriber',password:'subscriber',permission:2});
login2.save();

app.get('/login',function (req,res)
{
Login.findOne({"username":req.body.username, "password":req.body.password},function(err,data)
{
if(err)res.send(err);
else res.json(data);
//res.render('index',{login: data.permission })
});

});


app.get('/house',function (req,res)
{
House.find(
{
"type":req.body.type,
"bedroom":{$gte:req.body.bedroom},
"bathroom":{$gte:req.body.bathroom},
"price":{$gte:req.body.pricemin},
},
function(err,data)
{
res.json(data);
//res.render('index',{stuff:data})//make a view
});
});


app.post('/post',function(req,res){
new House({
description :req.body.descriptionPost,
type 		:req.body.typePost,
bedroom		:req.body.bedroomPost,
bathroom	:req.body.bathroomPost,
price		:req.body.pricePost,
address		:req.body.addressPost,
url			:req.body.urlPost,

}).save(function(err,doc){
if(err)console.log("Error");
else console.log("Saved");
res.redirect('/');
});

});

var server =http.createServer(app).listen(app.get('port'),function(){
console.log("App start: "+app.get('port') );

});
// ======================================================================