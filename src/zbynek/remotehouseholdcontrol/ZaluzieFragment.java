package zbynek.remotehouseholdcontrol;

import java.util.ArrayList;  
import java.util.List;  
   
import android.content.res.Configuration;  
import android.os.Bundle;  
import android.support.v4.app.Fragment;  
import android.support.v4.app.FragmentManager;  
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;  
import android.support.v4.app.FragmentTransaction;  
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.ViewGroup;  
import android.widget.AdapterView;  
import android.widget.AdapterView.OnItemClickListener;  
import android.widget.ArrayAdapter;  
import android.widget.ListView;  
import android.widget.Toast;  

public class ZaluzieFragment extends Fragment {
	
  /*
	  private List<String> mDataSourceList = new ArrayList<String>();  
	  private List<FragmentTransaction> mBackStackList = new ArrayList<FragmentTransaction>();  
	   
	   
	    @Override 
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
	            Bundle savedInstanceState) {  
	        return inflater.inflate(R.layout.fragment_list_layout, container, false);  
	    }  
	       
	       
	    @Override 
	    public void onActivityCreated(Bundle savedInstanceState) {  
	        super.onActivityCreated(savedInstanceState);  
	           
	        //add data to ListView  
	        for(int i=0, count=20; i<count; i++){  
	            mDataSourceList.add("neco_cinsky" + i);  
	        }  
	           
	         
	        ListView listView = (ListView) getActivity().findViewById(R.id.fragment_list);  
	        listView.setAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, mDataSourceList));  
	           
	        listView.setOnItemClickListener(new OnItemClickListener() {  
	   
	            @Override 
	            public void onItemClick(AdapterView<?> parent, View view,  
	                    int position, long id) {  
	                //create a Fragment  
	                Fragment detailFragment = new FragmentDetail();  
	                   
	               
	                Bundle mBundle = new Bundle();  
	                mBundle.putString("arg", mDataSourceList.get(position));  
	                detailFragment.setArguments(mBundle);  
	                   
	                final FragmentManager fragmentManager = getActivity().getSupportFragmentManager();  
	                final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();  
	                   
	                //check if the device is landscape or portrait 
	                Configuration configuration = getActivity().getResources().getConfiguration();  
	                int ori = configuration.orientation;  
	                   
	                fragmentTransaction.replace(R.id.detail_container, detailFragment);  
	                   
	                if(ori == configuration.ORIENTATION_PORTRAIT){  
	                    fragmentTransaction.addToBackStack(null);  
	                }  
	                   
	                fragmentTransaction.commit();  
	                   
	                   
	            }  
	        });  
	           
	    }  
*/
	       
	    /** 
	     *  
	     * @param msg 
	     */ 
	    private void showTost(String msg){  
	        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();  
	    }  
	       
    private String[][] StatesAndCapitals =
		{{"Alabama","Montgomery"},
		{"Alaska","Juneau"},
		{"Arizona","Phoenix"},
		{"Arkansas","Little Rock"},
		{"California","Sacramento"},
		{"Colorado","Denver"},
		{"Connecticut","Hartford"},
		{"Delaware","Dover"},
		{"Florida","Tallahassee"},
		{"Georgia","Atlanta"},
		{"Hawaii","Honolulu"},
		{"Idaho","Boise"},
		{"Illinois","Springfield"},
		{"Indiana","Indianapolis"},
		{"Iowa","Des Moines"},
		{"Kansas","Topeka"},
		{"Kentucky","Frankfort"},
		{"Louisiana","Baton Rouge"},
		{"Maine","Augusta"},
		{"Maryland","Annapolis"},
		{"Massachusetts","Boston"},
		{"Michigan","Lansing"},
		{"Minnesota","Saint Paul"},
		{"Mississippi","Jackson"},
		{"Missouri","Jefferson City"},
		{"Montana","Helena"},
		{"Nebraska","Lincoln"},
		{"Nevada","Carson City"},
		{"New Hampshire","Concord"},
		{"New Jersey","Trenton"},
		{"New Mexico","Santa Fe"},
		{"New York","Albany"},
		{"North Carolina","Raleigh"},
		{"North Dakota","Bismarck"},
		{"Ohio","Columbus"},
		{"Oklahoma","Oklahoma City"},
		{"Oregon","Salem"},
		{"Pennsylvania","Harrisburg"},
		{"Rhode Island","Providence"},
		{"South Carolina","Columbia"},
		{"South Dakota","Pierre"},
		{"Tennessee","Nashville"},
		{"Texas","Austin"},
		{"Utah","Salt Lake City"},
		{"Vermont","Montpelier"},
		{"Virginia","Richmond"},
		{"Washington","Olympia"},
		{"West Virginia","Charleston"},
		{"Wisconsin","Madison"},
		{"Wyoming","Cheyenne"}};
}