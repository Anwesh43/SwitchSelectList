## SwitchSelectList

### Android ui module to add a List of items which can be toggled by clicking on switch.

### Usage

#### Creating a SwitchSelectList in your Activity

```
    SwitchSelectList switchSelectList = new SwitchSelectList(this);
```

#### Adding option to the SwitchSelectList also the OnSelectionChangeListener object to listen for selection change events.

```
    switchSelectList.addOption(option,new OnSelectionChangeListener(){
        void onSelect() {

        }
        void onUnSelect() {

        }
    });
```

#### Showng the SwitchSelectList

```
    switchSelectList.show();
```

### Demo

<img src="https://github.com/Anwesh43/SwitchSelectList/blob/master/demo/switchselectlist.gif" width="300px" height="500px">
