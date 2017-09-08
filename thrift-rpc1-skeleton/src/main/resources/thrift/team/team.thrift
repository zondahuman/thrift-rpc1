include "business.thrift" 
include "teamInfo.thrift" 
include "userRole.thrift" 
namespace java com.abin.lee.thrift.rpc.api
 

service  TeamService {
  list<teamInfo.TeamInfo> findTeamListById(1:i64 id)
  teamInfo.TeamInfo findTeamById(1:i64 id)
  i64 findByIdAndType(1:i64 id, 2:string species)
  double findById(1:i64 id)
  userRole.BusinessRoleEnum findByBid(1:i64 id)
  void insert(1:business.Business business)
  business.Business findBusinessByBid(1:i64 id)
}