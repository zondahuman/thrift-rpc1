include "orderInfo.thrift" 
namespace java com.abin.lee.thrift.rpc.api
 

service OrderService {
  list<i64> findById(1:i64 id)
  orderInfo.OrderInfo findOrderById(1:i64 id)
  i64 findBysource(1:string source)
  double findPriceById(1:i64 id)
  list<orderInfo.OrderInfo> findListById(1:i64 id)
  void insert(1:orderInfo.OrderInfo orderInfo)
  orderInfo.OrderInfo findOrderByIdAndSource(1:i64 id,2:string source)
  void update(1:orderInfo.OrderInfo orderInfo)

}