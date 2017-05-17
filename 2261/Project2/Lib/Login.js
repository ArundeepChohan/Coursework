var mongoose = require('mongoose');
var loginSchema = new mongoose.Schema({
username: String,
password: String,
permission: Number
},{collection:"login"});

var Login = mongoose.model('Login',loginSchema);
module.exports = Login;