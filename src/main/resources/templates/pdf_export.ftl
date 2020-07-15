<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>
            Title
        </title>
        <style>
            @page { size: 279mm 216mm; } table{ margin: auto; border: 1px solid #333;
            border-bottom: none; border-left: none; font-family: SimSun; } td{ height:
            30px; border: 1px solid #333; border-top: none; text-align: center; position:
            relative; } tr.title{ font-weight: bold; } td.title{ height: 50px; font-weight:
            bold; } td.value{ color: blue; } td.content{ font-size: 12px; text-align:
            left; } td.sign{ text-align: left; height: 40px; }
            img{ 
                width: auto; 
                height: auto; 
                max-width: 900px; 
                max-height: 700px; 
            } 
        </style>
    </head>
    
    <body>
        <table class="table" cellspacing="0">
            <tr>
                <td class="title" colspan="10">
                    项目信息
                </td>
            </tr>
            <tr>
                <td style="width: 10%;">
                    项目名称
                </td>
                <td class="value" colspan="2">
                    <#if prjProject??>
                        <#if prjProject.name??>
                            ${prjProject.name}
                        </#if>
                    </#if>
                </td>
                <td style="width: 10%;">
                    项目地点
                </td>
                <td class="value" colspan="2">
                    <#if prjProject??>
                        <#if prjProject.location??>
                            ${prjProject.location}
                        </#if>
                    </#if>
                </td>
                <td style="width: 10%;">
                    建筑设计
                </td>
                <td class="value" colspan="3">
                    <#if prjProject??>
                        <#if prjProject.company??>
                            ${prjProject.company}
                        </#if>
                    </#if>
                </td>
            </tr>
            <tr>
                <td style="width: 10%;">
                    建筑面积
                </td>
                <td class="value" colspan="2">
                    <#if prjProject??>
                        <#if prjProject.areaOfStructure??>
                            ${prjProject.areaOfStructure}平方米
                        </#if>
                    </#if>
                </td>
                <td style="width: 10%;">
                    开发时间
                </td>
                <td class="value" colspan="2">
                    <#if prjProject??>
                        <#if prjProject.openTime??>
                            ${prjProject.openTime}
                        </#if>
                    </#if>
                </td>
                <td style="width: 10%;">
                    建筑处主体尺寸
                </td>
                <td class="value" colspan="3">
                    <#if prjProject??>
                        <#if prjProject.length??>
                            L=${prjProject.length}m W=${prjProject.width}m H=${prjProject.height}m
                        </#if>
                    </#if>
                </td>
            </tr>
            <tr>
                <td style="width: 10%;">
                    项目简介
                </td>
                <td class="value" colspan="9">
                    <#if prjProject??>
                        <#if prjProject.design??>
                            ${prjProject.design}
                        </#if>
                    </#if>
                </td>
            </tr>
            <tr>
                <td style="width: 10%;">
                    立面材料
                </td>
                <td class="value" colspan="9">
                    <#if prjProject??>
                        <#if prjProject.material??>
                            ${prjProject.material}
                        </#if>
                    </#if>
                </td>
            </tr>
            <tr>
                <td class="title" colspan="10">
                    其他信息
                </td>
            </tr>
            <tr>
                <td style="width: 10%;">
                    城市
                </td>
                <td class="value" style="width: 15%;">
                    <#if prjProject??>
                        <#if prjProject.city??>
                            ${prjProject.city}
                        </#if>
                    </#if>
                </td>
                <td style="width: 10%;">
                    位置
                </td>
                <td class="value" style="width: 15%;">
                    <#if prjProject??>
                        <#if prjProject.area??>
                            ${prjProject.area}
                        </#if>
                    </#if>
                </td>
                <td style="width: 10%;">
                    风格
                </td>
                <td class="value" style="width: 15%;">
                    <#if prjProject??>
                        <#if prjProject.style??>
                            ${prjProject.style}
                        </#if>
                    </#if>
                </td>
                <td style="width: 10%;">
                    后期
                </td>
                <td class="value" style="width: 15%;">
                    <#if prjProject??>
                        <#if prjProject.later??>
                            ${prjProject.later}
                        </#if>
                    </#if>
                </td>
               
            </tr>
            <tr>
                <td style="width: 10%;">
                    区位
                </td>
                <td class="value" style="width: 15%;">
                    <#if prjProject??>
                        <#if prjProject.position??>
                            ${prjProject.position}
                        </#if>
                    </#if>
                </td>
                <td style="width: 10%;">
                    形体
                </td>
                <td class="value" style="width: 15%;">
                    <#if prjProject??>
                        <#if prjProject.shape??>
                            ${prjProject.shape}
                        </#if>
                    </#if>
                </td>
                <td style="width: 10%;">
                    规模
                </td>
                <td class="value" style="width: 15%;">
                    <#if prjProject??>
                        <#if prjProject.scope??>
                            ${prjProject.scope}
                        </#if>
                    </#if>
                </td>
                <td style="width: 10%;">
                    竖向
                </td>
                <td class="value" style="width: 15%;">
                    <#if prjProject??>
                        <#if prjProject.vertical??>
                            ${prjProject.vertical}
                        </#if>
                    </#if>
                </td>               
            </tr>
        </table>
 		<p style="page-break-after: always;"></p>
 		
        <div>
            <#if prjProject.pictures?exists>
                <#list prjProject.pictures as picture>
                    <img src="${picture.url}" />
                     <p style="page-break-after: always;"></p>
                </#list>
            </#if>
        </div>
    </body>

</html>
