<?php
$res=array();
$s="localhost"; $u="root"; $p=""; $db="a4";
$con=new mysqli($s,$u,$p,$db);
$MaSP=$_POST['MaSP'];//truyen tham so cho bien MaSP
$sql="DELETE FROM SanPham WHERE MaSP='$MaSP'";
if($con->query($sql)===TRUE){
    $res['success']=1;
    $res['message']="Xoa thanh cong";
    echo json_encode($res);
}
else{
    $res['success']=0;
    $res['message']="Xoa that bai";
    echo json_encode($res);
}
$con->close();
//http://localhost/000/2024071/insert1.php?MaSP=SP3&TenSP=san pham 333&MoTa=mo ta san pham 3333