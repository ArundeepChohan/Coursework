var express = require('express');
var router = express.Router();
var mongoose = require('mongoose');

mongoose.connect('mongodb://localhost:27017/test');
//mongodb://<dbuser>:<dbpassword>@ds029675.mlab.com:29675/cloaks16 //wants to host on mongodb cloud later
var loginSchema = new mongoose.Schema({
username: String,
password: String,
permission: Number
},{collection:"login"});

var Login = mongoose.model('Login',loginSchema);

var login1 ={username:"admin",password:"admin",permission:1};
var login3 ={username:"user",password:"user",permission:3};
var login2 ={username:"subscriber",password:"subscriber",permission:2};

var houseSchema = new mongoose.Schema({
price: Number,
bedroom: Number,
bathroom: Number,
type: String,
url: String,
address: String,
description: String
},{collection:"house"});

var House = mongoose.model('House',houseSchema);

router.get('/house', function(req, res, next) {

House.find({}, function(err,docs){
 res.render('index',{items:docs}); 
  });
  
  });

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index');
});

router.post('/post', function(req, res, next) {
var item = {
description :req.body.descriptionPost,
type 		:req.body.typePost,
bedroom		:req.body.bedroomPost,
bathroom	:req.body.bathroomPost,
price		:req.body.pricePost,
address		:req.body.addressPost,
url			:req.body.urlPost,
 };

  var data = new House(item);
  data.save();
  res.redirect('/');
});
router.post('/update', function(req, res, next) {
House.update(
{_id:req.body.updateId},
{ $set:{bedroom:req.body.bedroomUpdate,
bathroom:req.body.bathroomUpdate,type:req.body.typeUpdate,url:req.body.urlUpdate,description:req.body.descriptionUpdate}}
);
res.redirect('/');
});

router.post('/delete', function(req, res, next) {
	var id = req.body.id;
	House.findByIdAndRemove(id).exec();
	res.redirect('/');
});

module.exports = router;
