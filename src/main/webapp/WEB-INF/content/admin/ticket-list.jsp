<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table class="table table-striped table-hover">
    <tr>
        <th>帖子标题</th>
        <th>发帖人</th>
        <th>修改</th>
        <th>删除</th>
    </tr>
    <%--<s:iterator value="ticketList" var="ticket">--%>
    <tr>
        <td>标题标题标题标题标题标题标题标题标题标标题标题</td>
        <td>人员</td>
        <td>
            <button class="btn btn-info" onclick="showModal(this.parentNode.parentNode)">修改</button>
        </td>
        <td>
            <button class="btn btn-warning" onclick="deleteTicket(${ticket.ticketId})">删除</button>
        </td>
    </tr>
    <%--</s:iterator>--%>
</table>

<div class="modal fade" id="ticketModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h2>修改机票</h2>
            </div>
            <div class="modal-body">
                <s:form cssClass="form-horizontal well" theme="bootstrap">
                    <s:textfield name="ticket.name" key="buyTicket.name" cssClass="input-lg"
                                 value="%{#session.user.userName}"/>
                    <s:radio name="ticket.sex" labelposition="inline"
                             list="%{#{'male':getText('buyTicket.sex.male'),'female':getText('buyTicket.sex.female')}}"
                             key="buyTicket.sex" cssErrorClass="foo" value="'male'"/>
                    <s:textfield name="ticket.originating" key="buyTicket.originating" cssClass="input-lg"/>
                    <s:textfield name="ticket.destination" key="buyTicket.destination" cssClass="input-lg"/>
                    <s:textfield name="ticket.departureDate" key="buyTicket.departureDate" cssClass="input-lg"/>
                    <s:textfield name="ticket.idCard" key="buyTicket.idCard" cssClass="input-lg"/>
                </s:form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info" onclick="changeTicket()">提交</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">放弃</button>
            </div>
        </div>
    </div>
</div>


<script>
    var action = "${requestScope.actionName}";
    var tempNode;

    function showModal(node) {
        tempNode = parseNode(node);
        console.log(tempNode);
        $('#ticketModal').modal('show');
        $('#' + action + '_ticket_name').val(tempNode.name);
        $('#' + action + '_ticket_sex').val(tempNode.sex);
        $('#' + action + '_ticket_originating').val(tempNode.originating);
        $('#' + action + '_ticket_destination').val(tempNode.destination);
        $('#' + action + '_ticket_departureDate').val(tempNode.departureDate);
        $('#' + action + '_ticket_idCard').val(tempNode.idCard);
    }

    function parseNode(node) {
        var ticket = {};
        var n = $(node);
        ticket.ticketId = n.attr("ticketId");
        var child = n.children();
        ticket.name = child[0].textContent;
        ticket.sex = child[1].textContent;
        ticket.originating = child[2].textContent;
        ticket.destination = child[3].textContent;
        ticket.departureDate = child[4].textContent;
        ticket.idCard = child[5].textContent;
        return ticket;
    }

    function changeTicket() {
        $.post("/v1/api/changeTicket", {
                'ticket.ticketId': tempNode.ticketId,
                'ticket.name': $('#' + action + '_ticket_name').val(),
                'ticket.sex': $("input[name='ticket.sex']:checked").val(),
                'ticket.originating': $('#' + action + '_ticket_originating').val(),
                'ticket.destination': $('#' + action + '_ticket_destination').val(),
                'ticket.departureDate': $('#' + action + '_ticket_departureDate').val(),
                'ticket.idCard': $('#' + action + '_ticket_idCard').val()
            },
            function (data, status) {
                window.location.reload();
            }
        );

    }

    function deleteTicket(ticketId) {
        $.post("/v1/api/deleteTicket",
            {'ticketId': ticketId},
            function (data, status) {
                window.location.reload();
            }
        );
    }
</script>