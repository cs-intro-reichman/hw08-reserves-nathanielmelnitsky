/** Represnts a list of musical tracks. The list has a maximum capacity (int),
 *  and an actual size (number of tracks in the list, an int). */
class PlayList {
    private Track[] tracks;  // Array of tracks (Track objects)   
    private int maxSize;     // Maximum number of tracks in the array
    private int size;        // Actual number of tracks in the array

    /** Constructs an empty play list with a maximum number of tracks. */ 
    public PlayList(int maxSize) {
        this.maxSize = maxSize;
        tracks = new Track[maxSize];
        size = 0;
    }

    /** Returns the maximum size of this play list. */ 
    public int getMaxSize() {
        return maxSize;
    }
    
    /** Returns the current number of tracks in this play list. */ 
    public int getSize() {
        return size;
    }

    /** Method to get a track by index */
    public Track getTrack(int index) {
        if (index >= 0 && index < size) {
            return tracks[index];
        } else {
            return null;
        }
    }
    
    /** Appends the given track to the end of this list. 
     *  If the list is full, does nothing and returns false.
     *  Otherwise, appends the track and returns true. */
    public boolean add(Track track) {
        //IN PROGRESS
        //find out if list is full
        if(size < maxSize){
            tracks[size] = track;
            //forgot to adjust the size here initially 
            //took forever to debug 
            //mental note to self not to make that mistake again
            size++;
            return true; 
        }
        else{
           return false;
        }
    }

    /** Returns the data of this list, as a string. Each track appears in a separate line. */
    //// For an efficient implementation, use StringBuilder.
    public String toString() {
        String asString = "\n";
        //loops through playlist adds each track as string to global
        for(int i = 0; i < size; i++){
           String trackInfo = tracks[i].toString();
           asString = asString + trackInfo + "\n";
        }
        return asString;
    }

    /** Removes the last track from this list. If the list is empty, does nothing. */
     public void removeLast() {
        if(size > 0){
            //size-1 becaus if not then you would remove an empty track
            tracks[size - 1] = null;
            size--;
        }
    }
    
    /** Returns the total duration (in seconds) of all the tracks in this list.*/
    public int totalDuration() {
        int totalCount = 0;
        for(int i = 0; i < size; i++){
            totalCount += tracks[i].getDuration();
        }
        return totalCount;
    }

    /** Returns the index of the track with the given title in this list.
     *  If such a track is not found, returns -1. */
    public int indexOf(String title) {
        //loops through tracks
        for(int i = 0; i < size; i++){
            //assigns lower case title to string for comparison purposes
            String currentTrack = tracks[i].getTitle().toLowerCase();
            //checks if titel is the same
            //uses string equator function 
            if(currentTrack.equals(title.toLowerCase())){
                //returns index of the title if the same
                return i;
            }
        }
        return -1;
    }

    /** Inserts the given track in index i of this list. For example, if the list is
     *  (t5, t3, t1), then just after add(1,t4) the list becomes (t5, t4, t3, t1).
     *  If the list is the empty list (), then just after add(0,t3) it becomes (t3).
     *  If i is negative or greater than the size of this list, or if the list
     *  is full, does nothing and returns false. Otherwise, inserts the track and
     *  returns true. */
    public boolean add(int i, Track track) {
        if(i < 0 || i > size ||  maxSize == size){
            return false;
        }
        else{
            //decrement loop (doesnt require temp saver)
            for (int j = size - 1; j >= i; j--) {
                tracks[j + 1] = tracks[j];
            }
            tracks[i] = track;
            size++;
            return true;
        }
    }
     
    /** Removes the track in the given index from this list.
     *  If the list is empty, or the given index is negative or too big for this list, 
     *  does nothing and returns -1. */
    public void remove(int i) {
       if(i >= 0 && i <= size){
            for(int k = i; k < size; k++){
                //does not require temp here because its an increment not decrement
                //therefore no loss of information
                tracks[k] = tracks[k+1];
            }
            size--;
        }
    }

    /** Removes the first track that has the given title from this list.
     *  If such a track is not found, or the list is empty, or the given index
     *  is negative or too big for this list, does nothing. */
    public void remove(String title) {
        //for empty list
        if(size == 0){
            return;
        }
        //loops through checking all the tracks
        //for same title name 
        for(int i = 0; i < size; i++){
            if(tracks[i].getTitle().equals(title)){
                //if same title then we start to upend in nested loop the titles after it
                for(int j = 0; j < size; j++){
                    //same as before no need for temp here because info is not lost
                    //if it were decrement we would need temp holder not to lose info
                    tracks[j] = tracks[j + 1];
                }
                //now we remove desired track
                tracks[size-1] = null;
                size--;
                return;
            }
        }
    }

    /** Removes the first track from this list. If the list is empty, does nothing. */
    public void removeFirst() {
        //can only be done on a nonempty list
        if(size != 0){
            for(int i = 0; i < size; i++){
                tracks[i] = tracks[i+1];
            }
            tracks[size - 1] = null;
            size--;
        }
        else{
            return;
        }
    }
    
    /** Adds all the tracks in the other list to the end of this list. 
     *  If the total size of both lists is too large, does nothing. */
    //// An elegant and terribly inefficient implementation.
     public void add(PlayList other) {
        //// replace this comment with your code
    }

    /** Returns the index in this list of the track that has the shortest duration,
     *  starting the search in location start. For example, if the durations are 
     *  7, 1, 6, 7, 5, 8, 7, then min(2) returns 4, since this the index of the 
     *  minimum value (5) when starting the search from index 2.  
     *  If start is negative or greater than size - 1, returns -1.
     */
    private int minIndex(int start) {
        //// replace the following statement with your code
        return 0;
    }

    /** Returns the title of the shortest track in this list. 
     *  If the list is empty, returns null. */
    public String titleOfShortestTrack() {
        return tracks[minIndex(0)].getTitle();
    }

    /** Sorts this list by increasing duration order: Tracks with shorter
     *  durations will appear first. The sort is done in-place. In other words,
     *  rather than returning a new, sorted playlist, the method sorts
     *  the list on which it was called (this list). */
    public void sortedInPlace() {
        // Uses the selection sort algorithm,  
        // calling the minIndex method in each iteration.
        //// replace this statement with your code
    }
}
