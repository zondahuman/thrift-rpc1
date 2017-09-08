include "couponInfo.thrift" 
namespace java com.abin.lee.thrift.rpc.api
 

service CouponService {
  list<i64> findById(1:i64 id)
  couponInfo.CouponInfo findCouponById(1:i64 id)
  i64 findBysource(1:string source)
  double findPriceById(1:i64 id)
  list<couponInfo.CouponInfo> findListById(1:i64 id)
  void insert(1:couponInfo.CouponInfo coupon)
  couponInfo.CouponInfo findCouponByIdAndSource(1:i64 id,2:string source)
}