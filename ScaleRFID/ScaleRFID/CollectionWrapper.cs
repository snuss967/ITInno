using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ScaleRFID
{
    class CollectionWrapper
    {
        public double weight { get; private set; }
        public int RFIDTag { get; private set; }
        public CollectionWrapper(int RFIDTag, double weight)
        {
            this.RFIDTag = RFIDTag;
            this.weight = weight;
        }
    }
}
