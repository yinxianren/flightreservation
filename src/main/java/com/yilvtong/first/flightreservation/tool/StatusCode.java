package com.yilvtong.first.flightreservation.tool;


import lombok.Getter;

@Getter
public enum StatusCode {
    SUCCESS(200,"操作成功！"),
    INTERNAL_ERROR_400_01(401,"未授权：登录失败！"),
    INTERNAL_ERROR_400_01_03(40103,"未授权：禁止访问资源！"),
    INTERNAL_ERROR_400_02(402,"未授权：服务器配置问题导致登录失败 ！"),
    INTERNAL_ERROR_400_04_01(40401,"未找到： 空参数 ！"),

    INTERNAL_ERROR_500_100(500,"内部服务器错误,该操作可能导致系统内部错误！"),
    INTERNAL_ERROR_500_13(500,"内部服务器错误, 服务器太忙 ！"),
    INTERNAL_ERROR_500_14_01(500,"应用程序无效, 插入数据失败！"),
    INTERNAL_ERROR_500_14_02(500,"应用程序无效, 上傳圖片失敗！"),
    INTERNAL_ERROR_500_14_03(500,"应用程序无效,  ftp创建目录失败！"),
    INTERNAL_ERROR_500_14_05(5001405,"应用程序无效, 目标对象已经存在！"),
    INTERNAL_ERROR_500_11(500,"内部服务器错误, 服务器关闭！");


    private  int code;
    private  String msg;

    StatusCode(int code,String msg){
       this.code=code;
       this.msg=msg;
    }



//
//    重点内容HTTP 400 - 请求无效
//    HTTP 401.1 - 未授权：登录失败
//    HTTP 401.2 - 未授权：服务器配置问题导致登录失败
//    HTTP 401.3 - ACL 禁止访问资源
//    HTTP 401.4 - 未授权：授权被筛选器拒绝
//    HTTP 401.5 - 未授权：ISAPI 或 CGI 授权失败
//    HTTP 403 - 禁止访问
//    HTTP 403 - 对 Internet 服务管理器 的访问仅限于 Localhost
//    HTTP 403.1 禁止访问：禁止可执行访问
//    HTTP 403.2 - 禁止访问：禁止读访问
//    HTTP 403.3 - 禁止访问：禁止写访问
//    HTTP 403.4 - 禁止访问：要求 SSL
//    HTTP 403.5 - 禁止访问：要求 SSL 128
//    HTTP 403.6 - 禁止访问：IP 地址被拒绝
//    HTTP 403.7 - 禁止访问：要求客户证书
//    HTTP 403.8 - 禁止访问：禁止站点访问
//    HTTP 403.9 - 禁止访问：连接的用户过多
//    HTTP 403.10 - 禁止访问：配置无效
//    HTTP 403.11 - 禁止访问：密码更改
//    HTTP 403.12 - 禁止访问：映射器拒绝访问
//    HTTP 403.13 - 禁止访问：客户证书已被吊销
//    HTTP 403.15 - 禁止访问：客户访问许可过多
//    HTTP 403.16 - 禁止访问：客户证书不可信或者无效
//    HTTP 403.17 - 禁止访问：客户证书已经到期或者尚未生效
//    HTTP 404.1 -无法找到 Web 站点
//    HTTP 404- 无法找到文件
//    HTTP 405 - 资源被禁止
//    HTTP 406 - 无法接受
//    HTTP 407 - 要求代理身份验证
//    HTTP 410 - 永远不可用
//    HTTP 412 - 先决条件失败
//    HTTP 414 - 请求 - URI 太长
//    HTTP 500 - 内部服务器错误
//    HTTP 500.100 - 内部服务器错误 - ASP 错误
//    HTTP 500-11 服务器关闭
//    HTTP 500-12 应用程序重新启动
//    HTTP 500-13 - 服务器太忙
//    HTTP 500-14 - 应用程序无效
//    HTTP 500-15 - 不允许请求 global.asaError 501 - 未实现
//    HTTP 502 - 网关错误
//    用户试图通过 HTTP 或文件传输协议 (FTP) 访问一台正在运行 Internet 信息服务 (IIS) 的服务器上的内容时，IIS 返回一个表示该请求的状态的数字代码。该状态代码记录在 IIS 日志中，同时也可能在 Web 浏览器或 FTP 客户端显示。状态代码可以指明具体请求是否已成功，还可以揭示请求失败的确切原因。日志文件的位置在默认状态下，IIS 把它的日志文件放在 %WINDIRSystem32Logfiles 文件夹中。每个万维网 (WWW) 站点和 FTP 站点在该目录下都有一个单独的目录。在默认状态下，每天都会在这些目录下创建日志文件，并用日期给日志文件命名（例如，exYYMMDD.log）。HTTP1xx - 信息提示
//    这些状态代码表示临时的响应。客户端在收到常规响应之前，应准备接收一个或多个 1xx 响应。
//
//            • 100 - 继续。
//            • 101 - 切换协议。2xx - 成功
//    这类状态代码表明服务器成功地接受了客户端请求。
//            • 200 - 确定。客户端请求已成功。
//            • 201 - 已创建。• 202 - 已接受。
//            • 203 - 非权威性信息。
//            • 204 - 无内容。
//            • 205 - 重置内容。
//            • 206 - 部分内容。3xx - 重定向
//    客户端浏览器必须采取更多操作来实现请求。例如，浏览器可能不得不请求服务器上的不同的页面，或通过代理服务器重复该请求。
//            • 302 - 对象已移动。
//            • 304 - 未修改。
//            • 307 - 临时重定向。4xx - 客户端错误
//    发生错误，客户端似乎有问题。例如，客户端请求不存在的页面，客户端未提供有效的身份验证信息。
//            • 400 - 错误的请求。
//            • 401 - 访问被拒绝。IIS 定义了许多不同的 401 错误，它们指明更为具体的错误原因。这些具体的错误代码在浏览器中显示，但不在 IIS 日志中显示：
//            • 401.1 - 登录失败。
//            • 401.2 - 服务器配置导致登录失败。
//            • 401.3 - 由于 ACL 对资源的限制而未获得授权。
//            • 401.4 - 筛选器授权失败。
//            • 401.5 - ISAPI/CGI 应用程序授权失败。
//            • 401.7 – 访问被 Web 服务器上的 URL 授权策略拒绝。这个错误代码为 IIS 6.0 所专用。
//            • 403 - 禁止访问：IIS 定义了许多不同的 403 错误，它们指明更为具体的错误原因：
//            • 403.1 - 执行访问被禁止。
//            • 403.2 - 读访问被禁止。
//            • 403.3 - 写访问被禁止。
//            • 403.4 - 要求 SSL。
//            • 403.5 - 要求 SSL 128。
//            • 403.6 - IP 地址被拒绝。
//            • 403.7 - 要求客户端证书。
//            • 403.8 - 站点访问被拒绝。
//            • 403.9 - 用户数过多。
//            • 403.10 - 配置无效。
//            • 403.11 - 密码更改。
//            • 403.12 - 拒绝访问映射表。
//            • 403.13 - 客户端证书被吊销。
//            • 403.14 - 拒绝目录列表。
//            • 403.15 - 超出客户端访问许可。
//            • 403.16 - 客户端证书不受信任或无效。
//            • 403.17 - 客户端证书已过期或尚未生效。
//            • 403.18 - 在当前的应用程序池中不能执行所请求的 URL。这个错误代码为 IIS 6.0 所专用。
//            • 403.19 - 不能为这个应用程序池中的客户端执行 CGI。这个错误代码为 IIS 6.0 所专用。• 403.20 - Passport 登录失败。这个错误代码为 IIS 6.0 所专用。
//            • 404 - 未找到。
//            • 404.0 -（无） – 没有找到文件或目录。
//            • 404.1 - 无法在所请求的端口上访问 Web 站点。• 404.2 - Web 服务扩展锁定策略阻止本请求。
//            • 404.3 - MIME 映射策略阻止本请求。
//            • 405 - 用来访问本页面的 HTTP 谓词不被允许（方法不被允许）
//            • 406 - 客户端浏览器不接受所请求页面的 MIME 类型。
//            • 407 - 要求进行代理身份验证。
//            • 412 - 前提条件失败。
//            • 413 – 请求实体太大。
//            • 414 - 请求 URI 太长。
//            • 415 – 不支持的媒体类型。
//            • 416 – 所请求的范围无法满足。
//            • 417 – 执行失败。
//            • 423 – 锁定的错误。5xx - 服务器错误服务器由于遇到错误而不能完成该请求。
//            • 500 - 内部服务器错误。
//            • 500.12 - 应用程序正忙于在 Web 服务器上重新启动。
//            • 500.13 - Web 服务器太忙。
//            • 500.15 - 不允许直接请求 Global.asa。
//            • 500.16 – UNC 授权凭据不正确。这个错误代码为 IIS 6.0 所专用。
//            • 500.18 – URL 授权存储不能打开。这个错误代码为 IIS 6.0 所专用。
//            • 500.100 - 内部 ASP 错误。
//            • 501 - 页眉值指定了未实现的配置。
//            • 502 - Web 服务器用作网关或代理服务器时收到了无效响应。
//            • 502.1 - CGI 应用程序超时。
//            • 502.2 - CGI 应用程序出错。application.
//• 503 - 服务不可用。这个错误代码为 IIS 6.0 所专用。
//            • 504 - 网关超时。
//            • 505 - HTTP 版本不受支持。常见的 HTTP 状态代码及其原因
//• 200 - 成功。 此状态代码表示 IIS 已成功处理请求。
//            • 304 - 未修改。客户端请求的文档已在其缓存中，文档自缓存以来尚未被修改过。客户端使用文档的缓存副本，而不从服务器下载文档。
//            • 401.1 - 登录失败。 登录尝试不成功，可能因为用户名或密码无效。
//            • 401.3 - 由于 ACL 对资源的限制而未获得授权。 这表示存在 NTFS 权限问题。即使您对试图访问的文件具备相应的权限，也可能发生此错误。例如，如果 IUSR 帐户无权访问 C:WinntSystem32Inetsrv 目录，您会看到这个错误。 有关如何解决此问题的其他信息，请单击下面的文章编号，查看 Microsoft 知识库中相应的文章：187506 INFO: IIS 4.0 的基础 NTFS 权限
//• 403.1 - 执行访问被禁止。 下面是导致此错误信息的两个常见原因： • 您没有足够的执行许可。例如，如果试图访问的 ASP 页所在的目录权限设为“无”，或者，试图执行的 CGI 脚本所在的目录权限为“只允许脚本”，将出现此错误信息。若要修改执行权限，请在 Microsoft 管理控制台 (MMC) 中右击目录，然后依次单击属性和目录选项卡，确保为试图访问的内容设置适当的执行权限。• 您没有将试图执行的文件类型的脚本映射设置为识别所使用的谓词（例如，GET 或 POST）。若要验证这一点，请在 MMC 中右击目录，依次单击属性、目录选项卡和配置，然后验证相应文件类型的脚本映射是否设置为允许所使用的谓词。
//            • 403.2 - 读访问被禁止。验证是否已将 IIS 设置为允许对目录进行读访问。另外，如果您正在使用默认文件，请验证该文件是否存在。有关如何解决此问题的其他信息，请单击下面的文章编号，查看 Microsoft 知识库中相应的文章：247677 错误信息：403.2 Forbidden:Read Access Forbidden（403.2 禁止访问：读访问被禁止）
//            • 403.3 - 写访问被禁止。 验证 IIS 权限和 NTFS 权限是否已设置以便向该目录授予写访问权。有关如何解决此问题的其他信息，请单击下面的文章编号，查看 Microsoft 知识库中相应的文章：248072 错误信息：403.3 Forbidden:Write Access Forbidden（403.3 禁止访问：写访问被禁止）
//            • 403.4 - 要求 SSL。禁用要求安全通道选项，或使用 HTTPS 代替 HTTP 来访问该页面。如果没有安装证书的 Web 站点出现此错误，请单击下面的文章编号，查看 Microsoft 知识库中相应的文章：224389 错误信息：HTTP 错误 403、403.4、403.5 禁止访问：要求 SSL
//• 403.5 - 要求 SSL 128。禁用要求 128 位加密选项，或使用支持 128 位加密的浏览器以查看该页面。如果没有安装证书的 Web 站点出现此错误，请单击下面的文章编号，查看 Microsoft 知识库中相应的文章：224389 错误信息：HTTP 错误 403、403.4、403.5 禁止访问：要求 SSL
//• 403.6 - IP 地址被拒绝。您已把您的服务器配置为拒绝访问您目前的 IP 地址。有关如何解决此问题的其他信息，请单击下面的文章编号，查看 Microsoft 知识库中相应的文章：248043 错误信息：403.6 - Forbidden:IP Address Rejected（403.6 - 不可用：IP 地址被拒绝）
//            • 403.7 - 要求客户端证书。您已把您的服务器配置为要求客户端身份验证证书，但您未安装有效的客户端证书。有关其他信息，请单击下面的文章编号，查看 Microsoft 知识库中相应的文章：190004 错误 403.7 或“Connection to Server Could Not Be Established”（无法建立与服务器的连接）186812 PRB：错误信息：403.7 Forbidden:Client Certificate Required（403.7 禁止访问：要求客户端证书）
//            • 403.8 - 站点访问被拒绝。您已为您用来访问服务器的域设置了域名限制。有关如何解决此问题的其他信息，请单击下面的文章编号，查看 Microsoft 知识库中相应的文章：248032 错误信息：Forbidden:Site Access Denied 403.8（禁止访问：站点访问被拒绝 403.8）
//            • 403.9 - 用户数过多。与该服务器连接的用户数量超过了您设置的连接限制。有关如何更改此限制的其他信息，请单击下面的文章编号，以查看 Microsoft 知识库中相应的文章：248074 错误信息：Access Forbidden:Too Many Users Are Connected 403.9（禁止访问：连接的用户太多 403.9）注意：Microsoft Windows 2000 Professional 和 Microsoft Windows XP Professional 自动设置了在 IIS 上最多 10 个连接的限制。您无法更改此限制。
//            • 403.12 - 拒绝访问映射表。 您要访问的页面要求提供客户端证书，但映射到您的客户端证书的用户 ID 已被拒绝访问该文件。有关其他信息，请单击下面的文章编号，以查看 Microsoft 知识库中相应的文章：248075 错误信息：HTTP 403.12 - Access Forbidden:Mapper Denied Access（HTTP 403.12 - 禁止访问：映射表拒绝访问）
//            • 404 - 未找到。 发生此错误的原因是您试图访问的文件已被移走或删除。如果在安装 URLScan 工具之后，试图访问带有有限扩展名的文件，也会发生此错误。这种情况下，该请求的日志文件项中将出现“Rejected by URLScan”的字样。
//            • 500 - 内部服务器错误。 很多服务器端的错误都可能导致该错误信息。事件查看器日志包含更详细的错误原因。此外，您可以禁用友好 HTTP 错误信息以便收到详细的错误说明。 有关如何禁用友好 HTTP 错误信息的其他信息，请单击下面的文章编号，以查看 Microsoft 知识库中相应的文章：294807 如何在服务器端禁用 Internet Explorer 5 的“显示友好 HTTP 错误信息”功能
//• 500.12 - 应用程序正在重新启动。 这表示您在 IIS 重新启动应用程序的过程中试图加载 ASP 页。刷新页面后，此信息即会消失。如果刷新页面后，此信息再次出现，可能是防病毒软件正在扫描 Global.asa 文件。有关其他信息，请单击下面的文章编号，以查看 Microsoft 知识库中相应的文章：248013 错误信息：HTTP Error 500-12 Application Restarting（HTTP 错误 500-12 应用程序正在重新启动）
//            • 500-100.ASP - ASP 错误。 如果试图加载的 ASP 页中含有错误代码，将出现此错误信息。若要获得更确切的错误信息，请禁用友好 HTTP 错误信息。默认情况下，只会在默认 Web 站点上启用此错误信息。有关如何在非默认的 Web 站点上看到此错误信息的其他信息，请单击下面的文章编号，以查看 Microsoft 知识库中相应的文章：261200 显示 HTTP 500 错误信息，而不显示 500-100.asp 的 ASP 错误信息
//• 502 - 网关错误。 如果试图运行的 CGI 脚本不返回有效的 HTTP 标头集，将出现此错误信息。
//    FTP1xx - 肯定的初步答复
//    这些状态代码指示一项操作已经成功开始，但客户端希望在继续操作新命令前得到另一个答复。
//            • 110 重新启动标记答复。
//            • 120 服务已就绪，在 nnn 分钟后开始。
//            • 125 数据连接已打开，正在开始传输。
//            • 150 文件状态正常，准备打开数据连接。2xx - 肯定的完成答复一项操作已经成功完成。客户端可以执行新命令。
//            • 200 命令确定。
//            • 202 未执行命令，站点上的命令过多。
//            • 211 系统状态，或系统帮助答复。
//            • 212 目录状态。
//            • 213 文件状态。
//            • 214 帮助消息。
//            • 215 NAME 系统类型，其中，NAME 是 Assigned Numbers 文档中所列的正式系统名称。
//            • 220 服务就绪，可以执行新用户的请求。
//            • 221 服务关闭控制连接。如果适当，请注销。
//            • 225 数据连接打开，没有进行中的传输。
//            • 226 关闭数据连接。请求的文件操作已成功（例如，传输文件或放弃文件）。
//            • 227 进入被动模式 (h1,h2,h3,h4,p1,p2)。
//            • 230 用户已登录，继续进行。
//            • 250 请求的文件操作正确，已完成。
//            • 257 已创建“PATHNAME”。3xx - 肯定的中间答复该命令已成功，但服务器需要更多来自客户端的信息以完成对请求的处理。
//            • 331 用户名正确，需要密码。
//            • 332 需要登录帐户。
//            • 350 请求的文件操作正在等待进一步的信息。4xx - 瞬态否定的完成答复该命令不成功，但错误是暂时的。如果客户端重试命令，可能会执行成功。
//            • 421 服务不可用，正在关闭控制连接。如果服务确定它必须关闭，将向任何命令发送这一应答。
//            • 425 无法打开数据连接。
//            • 426 Connection closed; transfer aborted.
//            • 450 未执行请求的文件操作。文件不可用（例如，文件繁忙）。
//            • 451 请求的操作异常终止：正在处理本地错误。
//            • 452 未执行请求的操作。系统存储空间不够。5xx - 永久性否定的完成答复该命令不成功，错误是永久性的。如果客户端重试命令，将再次出现同样的错误。
//            • 500 语法错误，命令无法识别。这可能包括诸如命令行太长之类的错误。
//            • 501 在参数中有语法错误。
//            • 502 未执行命令。
//            • 503 错误的命令序列。
//            • 504 未执行该参数的命令。
//            • 530 未登录。
//            • 532 存储文件需要帐户。
//            • 550 未执行请求的操作。文件不可用（例如，未找到文件，没有访问权限）。
//            • 551 请求的操作异常终止：未知的页面类型。
//            • 552 请求的文件操作异常终止：超出存储分配（对于当前目录或数据集）。
//            • 553 未执行请求的操作。不允许的文件名。



   }
