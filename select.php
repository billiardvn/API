<?php
$res=array();
$s="localhost"; $u="root"; $p=""; $db="a4";
$con=new mysqli($s,$u,$p,$db);
$sql="SELECT * FROM SanPham";
$result=$con->query($sql);//doc du lieu va tra ve result
if($result->num_rows>0){//neu so dong >0
    $res['products']=array();
    while($row=$result->fetch_assoc()){//doc tung dong
        $product=array();
        $product['MaSP']=$row['MaSP'];
        $product['TenSP']=$row['TenSP'];
        $product['MoTa']=$row['MoTa'];
        array_push($res['products'],$product);//day du lieu doc duoc vao mang
    }
    $res['success']=1;
    $res['message']="select thanh cong";
    echo json_encode($res);
}
else{
    $res['success']=0;
    $res['message']="khong co du lieu";
    echo json_encode($res);
}
$con->close();
//http://localhost/000/2024071/insert1.php?MaSP=SP3&TenSP=san pham 333&MoTa=mo ta san pham 3333