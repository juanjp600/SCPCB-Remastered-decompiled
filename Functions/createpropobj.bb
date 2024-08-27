Function createpropobj%(arg0$)
    Local local0.props
    For local0 = Each props
        If (local0\Field0 = arg0) Then
            Return copyentity(local0\Field1, $00)
        EndIf
    Next
    local0 = (New props)
    local0\Field0 = arg0
    local0\Field1 = loadmesh(arg0, $00)
    Return local0\Field1
    Return $00
End Function
