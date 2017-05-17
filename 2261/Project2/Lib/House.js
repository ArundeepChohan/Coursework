var mongoose = require('mongoose');
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
module.exports = House;