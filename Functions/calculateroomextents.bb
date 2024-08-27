Function calculateroomextents%(arg0.rooms)
    Local local0#
    Local local1#
    Local local2#
    If (arg0\Field7\Field18 <> 0) Then
        Return $00
    EndIf
    local0 = 0.05
    tformvector(arg0\Field7\Field19, arg0\Field7\Field20, arg0\Field7\Field21, arg0\Field2, $00)
    arg0\Field46 = ((tformedx() + local0) + arg0\Field3)
    arg0\Field47 = (tformedy() + local0)
    arg0\Field48 = ((tformedz() + local0) + arg0\Field5)
    tformvector(arg0\Field7\Field22, arg0\Field7\Field23, arg0\Field7\Field24, arg0\Field2, $00)
    arg0\Field49 = ((tformedx() - local0) + arg0\Field3)
    arg0\Field50 = (tformedy() - local0)
    arg0\Field51 = ((tformedz() - local0) + arg0\Field5)
    If (arg0\Field49 < arg0\Field46) Then
        local1 = arg0\Field49
        arg0\Field49 = arg0\Field46
        arg0\Field46 = local1
    EndIf
    If (arg0\Field51 < arg0\Field48) Then
        local2 = arg0\Field51
        arg0\Field51 = arg0\Field48
        arg0\Field48 = local2
    EndIf
    Return $00
End Function
