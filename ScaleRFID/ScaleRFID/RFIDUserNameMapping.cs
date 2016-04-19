using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ScaleRFID
{
    class RFIDUserNameMapping
    {
        private static RFIDUserNameMapping mapper;
        static bool instantiated = false;
        private static Dictionary<int, String> RFIDMap = new Dictionary<int, String>();
        private RFIDUserNameMapping()
        {
            //we will instantiate all of our classes we have right now
            //this is all we will ever instantiate we will not use this it is just a temporary fix 
            RFIDMap.Add(2431895,"Bill");
            RFIDMap.Add(1026046,"Tom");
            RFIDMap.Add(5099093,"Spencer");
            RFIDMap.Add(2329144,"Daniel");
            RFIDMap.Add(2412801,"Paul");
            RFIDMap.Add(2454861,"Aidan");
            RFIDMap.Add(2423366,"Matt");
            RFIDMap.Add(2404948,"Kevin");
            RFIDMap.Add(2239739, "Kangsum");
        }
        public static RFIDUserNameMapping getInstance()
        {
            if (instantiated)
            {
                return mapper;
            }
            else
            {
                mapper = new RFIDUserNameMapping();
                instantiated = true;
                return mapper;
            }
        }
        public string getUserName(int RFID)
        {
            string userName = RFIDMap[RFID];
            return userName;
        }
        public void addUserName(int RFID, string UserName)
        {
            RFIDMap.Add(RFID, UserName);
        }

    }
}
