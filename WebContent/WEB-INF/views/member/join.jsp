<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<main>
      <h2 class="main title">회원가입 폼</h2>
      
      <div class="breadcrumb" style="margin-top:-20px;">
         <h3 class="hidden">경로</h3>
         <img src="../resource/images/member/step2.png" alt="회원가입 1단계" />
      </div>
            
            
      <form id="form1" method="post" enctype="multipart/form-data">
         <fieldset>
            <legend class="hidden">회원정보</legend>
            <table class="table margin-top first">
               <tbody>
                  <tr>
                     <th><label>사진</label></th>
                     <td colspan="3" class="text-align-left indent" style="height: 60px;">
                        <input id="photo-file-button" type="file" name="file" class=""/>
                        <img id="photo" src="../resource/images/profile.png" style="width: 50px;height: 50px;border: 1px solid #595959; border-radius:25px; box-shadow: 0 4px 15px 0 rgba(0, 0, 0, 0.15);"/>
                        <input class="btn-text btn-default" type="button" id="photo-button" value="사진선택" />
                     </td>
                  </tr>
                  <tr>
                     <th><label>아이디</label></th>
                     <td colspan="3" class="text-align-left indent">				<!--required 속성을 사용하면 전송이 안됨  -->
                        <input id="id-text" type="text" name="id" class="width-half"  required="required" value="" placeholder="영문과 숫자 6~20자 이내" pattern="^\w{6,20}$" />
                        <input class="btn-text btn-default" type="button" id="id-check-button" value="중복확인" />                        
                     </td>
                  </tr>
                  <tr>
                     <th><label>비밀번호</label></th>
                     <td colspan="3" class="text-align-left indent">
                        <input type="password" name="pwd" class="" required placeholder="8자 이상(단 대문자,소문자,특수기호,숫자 모두 1이상씩 포함)" pattern="^^(?=(.*\d){2})(?=.*[a-zA-Z])(?=.*[!@#$%])[0-9a-zA-Z!@#$%]{8,}$" />
                     </td>
                  </tr>
                  <tr>
                     <th><label>비밀번호 확인</label></th>
                     <td colspan="3" class="text-align-left indent"><input class="" name="pwd2" type="password" required /></td>
                  </tr>
                  <tr>
                     <th><label>이름</label></th>
                     <td colspan="3" class="text-align-left indent"><input class="width-half" name="name" type="text"  value="" required="required"/></td>
                  </tr>
                  <!-- <tr>
                     <th><label>필명</label></th>
                     <td colspan="3" class="text-align-left indent"><input class="width-half" name="nicname" type="text" /></td>
                  </tr> -->
                  <tr>
                     <th><label>성별</label></th>
                     <td colspan="3" class="text-align-left indent">
                        
                        <select class="width-half" name="gender" required>
                           <option value="">선택</option>
                           <option value="남성">남성</option>
                           <option value="여성">여성</option>
                        </select>
                     </td>
                  </tr>
                  <tr>
                     <th><label>생년월일</label></th>
                     <td colspan="3" class="text-align-left indent">
                                                
                        <input name="birthday" type="date" class="width-half" required placeholder="예) 2000-02-17"  value=""/>
                        <!-- <input name="y" type="text" class="width-small margin-hor" style="margin-left:0px;" />년
                        <input name="m" type="text" class="width-small margin-hor" />월
                        <input name="d" type="text" class="width-small margin-hor" />일 -->
                        <input type="radio" name="isLunar" value="0" class="vertical-middle margin-hor" />양력
                        <input type="radio" name="isLunar" value="1" class="vertical-middle margin-hor" />음력
                     </td>
                  </tr>
                  
                  <%-- <%
                  String city = request.getParameter("city");
                  String[] cites = request.getParameterValues("city");
                  %> --%>
                  
                  <tr>
                     <th><label>핸드폰번호</label></th>
                     <td colspan="3" class="text-align-left indent"><input name="phone" type="text" class="width-half" pattern="^01[016789]-\d{3,4}-\d{4}$" placeholder="예) 010-1111-2222" required  value="${member.phone}"/></td>
                  </tr>
                  <tr>
                     <th><label>이메일</label></th>
                     <td colspan="3" class="text-align-left indent"><input name="email" type="email" class="width-half" required placeholder="예) user@newlecture.com"  value="${member.email}"/></td>
                  </tr>
                  <tr>
                     
                     <th colspan="1" class="text-align-right">다음 계산 결과는?<img src="" /></th>
                     <td colspan="3" class="text-align-left indent"><input type="text" name="checker" class="width-half" required placeholder="왼쪽 계산식의 결과를 입력하세요."/></td>
                  </tr>
                  
                  <tr>
                     <td colspan="4">
                        <input id="submit-Button" type="submit" name="btn" value="확인" style="height: 30px; margin:20px;" class="btn-text btn-default" />
                     </td>
                  </tr>
               </tbody>
            </table>
         </fieldset>
      </form>
   </main>
 
 
 
   <script>

    window.addEventListener("load",function() {
        var submitButton=document.querySelector("#id-check-button");
        var idCheckButton = document.querySelector("#id-check-button");
        var idInput = document.querySelector("input[name='id']");
        var photoButton = document.querySelector("#photo-button");
        var file = document.querySelector("#photo-file-button");
        var photo = document.querySelector("#photo");
        /*=======유효성 검사를 위한 필드==========================================================*/
        
           var idChecked =false;
        
        /*nkeydown - 모든 키를 눌렀을때(shift, alt, control, capslock 등의 키도 모두 인식한다. 단 한영변환,한자 등의 특수키는 인식못함.)

        onkeyup - 모든 키를 눌렀다 땠을때(onkeydown 에서 인식하는 키들을 인식)

        onkeypress - 실제로 글자가 써질때 (shift, enter 같은 키는 인식하지 못한다)*/


           idInput.onchange = function(){
               //alert("Test");
               idChecked = false;
           }
           
           /*idInput.onkeypress = function(e){
               alert(e.keyCode);
           };*/
        /*=======유효성 검사를 위한 필드==========================================================*/
		
        photoButton.onclick = function(e){
            //alert("Test");
                var event = new MouseEvent("click",{
                    'view':window,
                    'bubbles': true,
                    'cancelable':true
                });
               
                file.dispatchEvent(event);
        };
        
          /* file.onclick = function(e){
            alert("Clicked");
        };  */ 
         
        file.onchange = function(e){
        	//var files = file.files;
            var file1 = file.files[0];
        	
            var info = "name :" + file1.name;
            info += ", size : " + file1.size;
            info += ", type : " + file1.type;
            alert(info);
            
            /*for(var key in files[0])
            	alert(key);*/
            
            //      '/' 구분자로 문자열을 잘라서 앞에 문자열의 내용으로 비교
            //      "image/png" -> "image", "png"

            var typeParts = file1.type.split("/");
            //var typeParts = file1[0].type.split("/");
            
            if(typeParts[0] != "image")
                alert("지원되는 이미지 파일이 아닙니다.");

            var reader = new FileReader();
            reader.onload = function(evt){
                photo.src = evt.target.result;
            };
            reader.readAsDataURL(file1);
            
            
            // data1 = urlencoded
            // var data = "name = newlec&type=a";, name = newlec&type=a;

            // data2 = multipart
            //var data = new FormData();
            //data.append("key", value);

            //var request = new XMLHttpRequest();
            //request.onload = function(){ //이벤트
            
            //};

            //request.open("POST", "idcheck?id="+memberId,true); //true 비동기 = default값
            //request.send(data);
        };

        idCheckButton.onclick = function(){
            var memberId = idInput.value;
            
            if(memberId ==""){
            	alert("아이디를 입력해주세요.");
           		return;
         }
            
            var request = new XMLHttpRequest();
            
            request.onreadystatechange=function(){ //이벤트
                  
               if(request.readyState !=4)
                  return;
                  
            var member = JSON.parse(request.responseText);
            
             if(member==null)
               alert("사용 가능한 아이디입니다.");
             else
               alert("다시 입력해주세요. 현재 "+member.name+"회원님이 사용중인 아이디입니다.");  
                  
               };
            
            
            
            request.open("GET", "idcheck?id="+memberId,true); //true 비동기 = default값
            request.send(); //요청

           submitButton.onclick=function(e){
               if(!idChecked){

                   alert("아이디 중복 확인을 해주세요.");
                   e.preventDefault();
                   return;
               }


           };
            
        
        };
    });
    </script>