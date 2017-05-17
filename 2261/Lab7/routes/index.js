var express = require('express');
var router = express.Router();
router.get('/', function(req,res){
res.render('index',{name:"Arundeep Chohan"});

});

router.get('/realtime/show', function(req,res){
res.render('data',{});

});



module.exports = router;