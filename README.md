# Ezerver
基于 Socket 实现的一个简易的的 Web 服务器

 **注意 !! 该项目已不在此处继续更新，新的项目地址在　[Ezerver](https://github.com/Ericwyn/Ezerver)**
 
 **Note !! This item is no longer updated here. The new project address is　[Ezerver](https://github.com/Ericwyn/Ezerver)**
 
## 默认配置
 - 监听端口 9090
 - 静态网页 WEB_ROOT 位于 `webroot` 文件夹
 
## 使用示例


    public static void main(String[] args) throws Exception {
        
        // 新建一个 SimpleHttpServer
        SimpleHttpServer server = new SimpleHttpServer();
        // 设置 WebRoot 路径
        server.setWebRoot("/home/www/testWeb");
        // 设置监听端口号
        server.setServerPort(8080);
        // 开启服务
        server.start();
        Scanner in = new Scanner(System.in);
        while (true){
            if (in.nextInt() == -1){
                System.out.println("收到关闭请求");
                server.close();
                break;
            }
        }
        
    }
    

然后访问 localhost:8080 端口就可以了

 
