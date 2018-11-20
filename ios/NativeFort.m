
#import "NativeFort.h"

@implementation NativeFort

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(addEvent:(NSString *)message)
{
    RCTLogInfo(@"log message %@", message);
}

@end
  
