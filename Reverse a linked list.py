#Reverse a linked list

#Input - 1->2->3->4->5->NULL
#Output - 5->4->3->2->1->NULL 

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        #Base Case 
        if not head: #if head is null, return null
            return None 
        
        newHead = head #maintain the new head 
        #head is current node in the recursive call 
        if head.next: 
            newHead = self.reverseList(head.next)
            head.next.next = head 
        head.next = None 

        return newHead 