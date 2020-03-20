# Swipe to Answer View
<img src="https://raw.githubusercontent.com/mutasemhajhasan/SlideToAnswerView/master/demo.gif"  
     alt="Markdown Monster icon"  
     style="float: left; margin-right: 10px;" />
## Installation

    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	dependencies {
	        implementation 'com.github.mutasemhajhasan:SlideToAnswerView:1.0.0'
	}
    
## Usage
Activity.xml

    <me.mutasem.slidetoanswer.SwipeToAnswerView  
      android:id="@+id/StA"  
      android:layout_width="match_parent"  
      android:layout_height="wrap_content"  
      android:layout_alignParentStart="true"  
      android:layout_alignParentLeft="true"  
      android:layout_alignParentBottom="true"  
     />  
      
    <me.mutasem.slidetoanswer.SwipeToAnswerView  
      android:id="@+id/StA2"  
      android:layout_width="match_parent"  
      android:layout_height="wrap_content"  
      android:layout_alignParentEnd="true"  
      android:layout_alignParentRight="true"  
      android:layout_alignParentBottom="true"  
      app:icon="@drawable/ic_decline"  
      app:reverse="true" />
Activity.java

    answer = findViewById(R.id.StA);  
    answer.setSlideListner(new SwipeToAnswerView.SlideListner() {  
        @Override  
      public void onSlideCompleted() {  
            Toast.makeText(MainActivity.this, "Slide completed", Toast.LENGTH_SHORT).show();  
      decline.stopAnimation();  
      }  
    });  
    decline = findViewById(R.id.StA2);  
    decline.setSlideListner(new SwipeToAnswerView.SlideListner() {  
        @Override  
      public void onSlideCompleted() {  
            Toast.makeText(MainActivity.this, "Reverse completed", Toast.LENGTH_SHORT).show();  
      answer.stopAnimation();  
      }  
    });
## License
This content is released under the GNU License
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)
    

