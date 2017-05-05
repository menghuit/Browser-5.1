# Browser-5.1
base on Browser-cts-5.1_r18

注释所有 product="nosdcard" 的行
find . -name "strings.xml" -type f |xargs sed -i '/product=\"nosdcard\"/{s/^/<!-- &/;s/$/& -->/}'

***AddBookmarkPage.java
    WebAddress类 is hided

***Controller.java
    属性 hide

***DownloadHandler.java
    WebAddress

***KeyChainLookup.java
    ClientCertRequest api min 21

***Performance.java
    WebAddress

***Tab.java
    ClientCertRequest api min 21

***UploadHandler.java
    FileChooserParams api min 21