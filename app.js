//tham chieu thu vien
const express=require('express');
const mongoose=require('mongoose');
const sinhVienRoute=require('./routes/sinhvienRoute');
const bodyParser = require('body-parser');
//tao doi tuong express
const app=express();
//ket noi voi mongodb
mongoose.connect('mongodb://localhost:27017/AND103',{
    useNewUrlParser: true,
    useUnifiedTopology: true
}).then(()=>{
    console.log("ket noi thanh cong voi mongodb");
}).catch((err)=>{
    console.error("Loi ket noi: ",err);
});
app.use(bodyParser.urlencoded({extended:false}));
app.use(express.json());
//su dung route
app.use('/',sinhVienRoute);

//su dung EJS lam view engine
app.set('view engine','ejs');
//khoi dong server
const PORT=process.env.PORT||3000;
app.listen(PORT,()=>{
    console.log("server dang chay o cong 3000");
});