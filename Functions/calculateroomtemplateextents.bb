Function calculateroomtemplateextents%(arg0.roomtemplates)
    If (arg0\Field18 <> 0) Then
        Return $00
    EndIf
    getmeshextents(getchild(arg0\Field0, $02))
    arg0\Field19 = mesh_minx
    arg0\Field20 = mesh_miny
    arg0\Field21 = mesh_minz
    arg0\Field22 = mesh_maxx
    arg0\Field23 = mesh_maxy
    arg0\Field24 = mesh_maxz
    Return $00
End Function
