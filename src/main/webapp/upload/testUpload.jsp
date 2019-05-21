<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	request.setAttribute("path", request.getContextPath());
%>
<title>利用fromDate提交表单</title>
<body>
<h1>使用formData形式上传文件</h1>
    <form id="uploadForm" method="post" action="/upload" >
        <input type="file" id="avatar" name="avatar" onchange="previewImage('preview',this)" >
        <img id="preview">
        <button id="submit" type="button">提交</button>
    </form>
</body>
<script src="${path }/js/jquery.min.js"></script>
<script type="text/javascript">
    function previewImage(preImageId, imageFile) {
        var pattern = /(\.*.jpg$)|(\.*.png$)|(\.*.jpeg$)|(\.*.gif$)|(\.*.bmp$)/;
        if (!pattern.test(imageFile.value)) {
            alert("系统仅支持jpg/jpeg/png/gif/bmp格式的照片！");
            imageFile.focus();
            $(imageFile).val("");
            return false;
        } else {
            var path;
            if (document.all)//IE
            {
                imageFile.select();
                path = document.selection.createRange().text;
            }
            else//FF
            {
                path = URL.createObjectURL(imageFile.files[0]);
            }
            $('#' + preImageId).attr('src', path);
        }
    }

    $('#submit').on('click',function () {
        var formData = new FormData($( "#uploadForm" )[0]);
        console.log(formData);
        $.ajax({
            type: 'POST',
            url: '/upload',
            data: formData,
            contentType: false,
            processData: false,
            success: function (result) {
                console.log(result);
            },
        });
    });
</script>
</html>