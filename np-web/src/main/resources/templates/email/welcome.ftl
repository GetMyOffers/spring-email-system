<!DOCTYPE html>
<html lang="en">
<#--<#include "/common/header.ftl">-->
<body>
<#--<#include "/common/elements.ftl"/>-->

<div id="page-wrapper" align="center">
    <div class="row">
        <div class="col-lg-12">
            <h2 class="page-header">内部邮件发送系统</h2>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div id="dataTables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                        <div class="row">
                            <div class="col-sm-12 table-scroll">
                                <table class="table table-striped table-bordered table-hover dataTable no-footer dtr-inline" id="dataTables-example">
                                    <thead>
                                    </thead>
                                    <tbody>
                                    <tr class="-to" role="row" >
                                        <td>收件人</td>
                                        <td>
                                            <div class="col-sm-12 table-scroll">
                                                <textarea id="to" style="width:700px; height:500px;" value=""/></textarea>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr class="-subject" role="row" >
                                        <td>主题</td>
                                        <td><input value="" id="subject"/></td>
                                    </tr>
                                    <tr class="-templateType" role="row" >
                                        <td>模版</td>
                                        <td>
                                            <select class="templateType">
                                                <#if fileNames??>
                                                    <#list fileNames as item>
                                                        <option value ="volvo" selected="">${item}</option>
                                                    </#list>
                                                </#if>
                                            </select>
                                        </td>
                                    </tr>


                                    </tbody>
                                </table>
                            </div>
                            <div>
                                <input value="取消" type="button" id="btn-cancel"/>
                                <input value="发送" type="button" id="btn-submit"/>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.panel-body -->
            <#--<@pageNav total= "${(jobs.totalPages?c)!1}" current="${(jobs.page?c)!1}" urlpattern="?page=%d" />-->
            </div>
            <!-- /.panel -->
        </div>
    </div>
</div>

<!-- /#wrapper -->

<#--<#include "/common/footer.ftl"/>-->
<script src="http://code.jquery.com/jquery-latest.js"></script>

<script>
    $(function(){
        $('#btn-cancel').on('click', function(e){
            e.stopPropagation();
            alert("取消成功!!!");
            url = "/email";
            window.location.href = '/email';
        })
    }),

    $(function(){
        $('#btn-submit').on('click', function(e){
            var to = $('#to').val();
            var subject = $('#subject').val();
            var templateType = $('.templateType option:selected').text();

            e.stopPropagation();
            $.ajax({
                type: 'POST',
                url: '/email/send',
                data: {
                    "to": to,
                    "subject": subject,
                    "templateType": templateType
                },
                success: function (data) {
//                    if (data.code !== 0) {
//                        alert(data.msg);
//                        return false;
//                    }
                    alert("邮件发送成功");
                    window.location.href = '/email';
                },
                error: function (err) {
                    alert("邮件发送失败");
                },
            })
        })
    })

</script>




</body>

</html>