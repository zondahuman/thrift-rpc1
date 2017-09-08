namespace java com.abin.lee.thrift.rpc.model


struct Business
{
  1:  i64 businessId,
  2:  string businessName,
  3:  string businessAddress,
  4:  i64    accountId,
  5:  i64    contractId
}