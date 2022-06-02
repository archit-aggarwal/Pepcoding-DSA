public int kthFromLast(int k){
      Node slow = head;
      Node fast = head;
      
      // fast & slow ke beech me gap le ao k ka
      for(int i=1; i<=k; i++){
          fast = fast.next;
      }
      
      // algorithm chalao jab tak fast tail na ban jae
      while(fast != tail){
          slow = slow.next;
          fast = fast.next;
      }
      
      return slow.data;
    }
